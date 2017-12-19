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
    private int monsterNum;
    private Monster keyMonster;
    private BossMonster boss;

    private Random random = new Random();

    private Maze maze;

    public GameController(){
        monsterNum = 3;
        maze = new Maze();
        maze.generate();
        hero = new Hero();
        initGame();
    }

    public void initGame() {
        monsterList = new ArrayList<>();
        int[] monsPos;

        for(int i = 0; i < monsterNum - 2; i ++) {
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

    public Hero getHero() {
        return hero;
    }
    public Monster getMonster(int i) {
        return monsterList.get(i);
    }

    public List<Monster> getMonsterList() {
        return monsterList;
    }

    public Maze getMaze() {
        return maze;
    }

    public void keyPressed(KeyEvent e) {

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

        if(heroMoved){
            for (int i = 0; i < monsterList.size(); i++) {
                monsterList.get(i).takeTurn(maze);
            }
        }

        if((keyMonster.isDead() && boss.isDead()) || monsterList.size() == 0) {
            nextLevel();
        }
    }

    public void nextLevel() {
        maze.generate();
        hero.updateLevel();
        hero.levelUp();
        hero.initCharacter();
        monsterNum = (int)(Math.random() * 3) + 3;

        initGame();
    }

    public void keyReleased(KeyEvent e) {

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

    public void gameOver(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(GAMEOVER_CONTAINER_POSX,GAMEOVER_CONTAINER_POSY,GAMEOVER__CONTAINER_WIDTH,GAMEOVER_CONTAINER_HEIGHT);

        g.setColor(Color.RED);
        g.setFont(new Font("Courier", Font.PLAIN, GAMEOVER_SIZE));
        g.drawString("You are Dead!!!", GAMEOVER_POSX, GAMEOVER_POSY);

    }

    public void drawInfo(Graphics g) {
        g.setColor(Color.white);
        g.setFont(new Font("Courier", Font.PLAIN, STATUS_SIZE));

        String statusTextHero = "";
        String statusTextMonster = "";

        g.fillRect(STATUS_CONTAINER_POSX, STATUS_CONTAINER_POSY, STATUS_CONTAINER_WIDTH, STATUS_CONTAINER_HEIGHT);
        g.setColor(Color.black);

        if(hero.isDead()) {
            gameOver(g);
        } else {
            statusTextHero = "Hero(Level" + hero.getLevel() + ")HP:" + hero.currentHealthPoint
                             + "/" + hero.maxHealthPoint
                             + "|SP:" + hero.strikePoint
                             + "|DP:"+ hero.defendPoint;

            for(int i = 0; i < monsterList.size(); i ++){
                if(hero.x == monsterList.get(i).x && hero.y == monsterList.get(i).y){
                    statusTextHero = "Hero(Level" + hero.getLevel() + ") HP:" + hero.currentHealthPoint
                                     + "/" + hero.maxHealthPoint
                                     + "|SP:" + hero.strikePoint
                                     + "|DP:"+ hero.defendPoint;

                    statusTextMonster = "Monster(Level" + monsterList.get(i).getLevel() + ")HP:"
                                       + monsterList.get(i).currentHealthPoint + "/" + monsterList.get(i).maxHealthPoint
                                       + "|SP:" + monsterList.get(i).strikePoint
                                       + "|DP:"+ monsterList.get(i).defendPoint;
                }
            }
        }

        g.drawString(statusTextHero, STATUS_POSX, STATUS_HERO_POSY);

        if(statusTextMonster.length() > 0){
            g.setColor(Color.white);
            g.fillRect(STATUS_CONTAINER_POSX, STATUS_CONTAINER_POSY + STATUS_CONTAINER_HEIGHT,
                    STATUS_CONTAINER_WIDTH, STATUS_CONTAINER_HEIGHT);
        }
        g.setColor(Color.black);
        g.drawString(statusTextMonster, STATUS_POSX, STATUS_MONSTER_POSY);
    }
}
