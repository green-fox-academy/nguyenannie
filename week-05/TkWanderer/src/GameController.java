import java.awt.*;
import java.util.*;
import java.awt.event.KeyEvent;
import java.util.List;

public class GameController {
    private static final int STATUS_WIDTH = 330;
    private static final int STATUS_HEIGHT = 20;
    private static final int STATUS_SIZE = 15;
    private static final int STATUS_POSX = Maze.MAZE_WIDTH * Tile.tileSize - STATUS_WIDTH;
    private static final int STATUS_HERO_POSY = 15;
    private static final int STATUS_MONSTER_POSY = STATUS_HERO_POSY + STATUS_HEIGHT;
    private static final int STATUS_CONTAINER_POSX = STATUS_POSX - 5;
    private static final int STATUS_CONTAINER_POSY = 0;
    private static final int STATUS_CONTAINER_WIDTH = STATUS_WIDTH + 5;
    private static final int STATUS_CONTAINER_HEIGHT = STATUS_HEIGHT;
    private static final int GAMEOVER_CONTAINER_POSX = 300;
    private static final int GAMEOVER_CONTAINER_POSY = 270;
    private static final int GAMEOVER__CONTAINER_WIDTH = 460;
    private static final int GAMEOVER_CONTAINER_HEIGHT = 70;
    private static final int GAMEOVER_SIZE = 50;
    private static final int GAMEOVER_POSX = GAMEOVER_CONTAINER_POSX + 5;
    private static final int GAMEOVER_POSY = GAMEOVER_CONTAINER_POSY + GAMEOVER_SIZE;

    private Hero hero;
    private List<Monster> monsterList;
    private int monsterAmount;
    private Monster keyMonster;
    private BossMonster boss;

    private Random random = new Random();

    private Maze maze;

    GameController() {
        monsterAmount = 3;
        maze = new Maze();
        maze.generate();
        hero = new Hero();
        initGame();
    }

    private void initGame() {
        monsterList = new ArrayList<>();
        int[] monsPos;

        for(int i = 0; i < monsterAmount - 2; i ++) {
            monsPos = findEmptyTile();
            monsterList.add(new Monster(monsPos[0], monsPos[1],hero.level, false));
        }

        monsPos = findEmptyTile();
        keyMonster = new Monster(monsPos[0], monsPos[1],hero.level,true);

        monsPos = findEmptyTile();
        boss = new BossMonster(monsPos[0], monsPos[1],hero.level);

        monsterList.add(keyMonster);
        monsterList.add(boss);
    }

    private int[] findEmptyTile() {
        int[] pos = new int[2];

        do {
            pos[0] = random.nextInt(10);
            pos[1] = random.nextInt(11);
        } while(getMaze().getTile(pos[0], pos[1]).orElse(Maze.WALL).isSolid);

        return pos;
    }

    Hero getHero() {
        return hero;
    }

    Monster getMonster(int i) {
        return monsterList.get(i);
    }

    List<Monster> getMonsterList() {
        return monsterList;
    }

    Maze getMaze() {
        return maze;
    }

    void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();
        boolean heroMoved = false;

        switch (key) {
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A:
                hero.move(maze, Hero.Directions.LEFT);
                heroMoved = true;
                break;

            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                hero.move(maze, Hero.Directions.RIGHT);
                heroMoved = true;
                break;

            case KeyEvent.VK_UP:
            case KeyEvent.VK_W:
                hero.move(maze, Hero.Directions.UP);
                heroMoved = true;
                break;

            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
                hero.move(maze, Hero.Directions.DOWN);
                heroMoved = true;
                break;

            case KeyEvent.VK_SPACE:
                for(int i = 0; i < monsterList.size(); i ++) {
                    if (monsterList.get(i).x == hero.x && monsterList.get(i).y == hero.y) {
                        hero.attack(monsterList.get(i));
                        if(monsterList.get(i).isDead()){
                            hero.getStronger();
                            monsterList.remove(i);
                        } else {
                            monsterList.get(i).attack(hero);
                        }
                    }
                }
        }

        if(heroMoved) {
            for (Monster monster : monsterList) {
                monster.takeTurn(maze);
            }
        }

        if((keyMonster.isDead() && boss.isDead()) || monsterList.size() == 0) {
            nextLevel();
        }
    }

    private void nextLevel() {
        maze.generate();
        hero.updateLevel();
        hero.levelUp();
        hero.initCharacter();
        monsterAmount = (int)(Math.random() * 3) + 3;

        initGame();
    }

    void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        switch (key) {
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A:
                break;

            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                break;

            case KeyEvent.VK_UP:
            case KeyEvent.VK_W:
                break;

            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
                break;
        }
    }

    private void gameOver(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(GAMEOVER_CONTAINER_POSX,GAMEOVER_CONTAINER_POSY,GAMEOVER__CONTAINER_WIDTH,GAMEOVER_CONTAINER_HEIGHT);

        g.setColor(Color.RED);
        g.setFont(new Font("Courier", Font.PLAIN, GAMEOVER_SIZE));
        g.drawString("You are Dead!!!", GAMEOVER_POSX, GAMEOVER_POSY);

    }

    void drawInfo(Graphics g) {
        g.setColor(Color.white);
        g.setFont(new Font("Courier", Font.PLAIN, STATUS_SIZE));

        String statusTextHero = "";
        String statusTextMonster = "";

        g.fillRect(STATUS_CONTAINER_POSX, STATUS_CONTAINER_POSY, STATUS_CONTAINER_WIDTH, STATUS_CONTAINER_HEIGHT);
        g.setColor(Color.black);

        if(hero.isDead()) {
            gameOver(g);
        } else {
            statusTextHero = "Hero(Level" + hero.getLevel() + ")HP:" + hero.healthPoint
                             + "/" + hero.maxHealthPoint
                             + "|SP:" + hero.strikePoint
                             + "|DP:"+ hero.defendPoint;

            for(Monster monster : monsterList){
                if(hero.x == monster.x && hero.y == monster.y){
                    statusTextHero = "Hero(Level" + hero.getLevel() + ") HP:" + hero.healthPoint
                                     + "/" + hero.maxHealthPoint
                                     + "|SP:" + hero.strikePoint
                                     + "|DP:"+ hero.defendPoint;

                    statusTextMonster = "Monster(Level" + monster.getLevel() + ")HP:"
                                       + monster.healthPoint + "/" + monster.maxHealthPoint
                                       + "|SP:" + monster.strikePoint
                                       + "|DP:"+ monster.defendPoint;
                }
            }
        }

        g.drawString(statusTextHero, STATUS_POSX, STATUS_HERO_POSY);

        if(statusTextMonster.length() > 0) {
            g.setColor(Color.white);
            g.fillRect(STATUS_CONTAINER_POSX, STATUS_CONTAINER_POSY + STATUS_CONTAINER_HEIGHT,
                    STATUS_CONTAINER_WIDTH, STATUS_CONTAINER_HEIGHT);
        }

        g.setColor(Color.black);
        g.drawString(statusTextMonster, STATUS_POSX, STATUS_MONSTER_POSY);
    }
}
