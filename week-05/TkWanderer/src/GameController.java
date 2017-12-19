import java.awt.*;
import java.util.*;
import java.awt.event.KeyEvent;
import java.util.List;

class GameController {
    private static final int STAT_WIDTH = 330;
    private static final int STAT_HEIGHT = 20;
    private static final int STAT_SIZE = 15;
    private static final int STAT_POSX = Maze.MAZE_WIDTH * Tile.tileSize - STAT_WIDTH;
    private static final int STAT_HERO_POSY = 15;
    private static final int STAT_MONSTER_POSY = STAT_HERO_POSY + STAT_HEIGHT;
    private static final int STAT_BOX_POSX = STAT_POSX - 5;
    private static final int STAT_BOX_POSY = 0;
    private static final int STAT_BOX_WIDTH = STAT_WIDTH + 5;
    private static final int STAT_BOX_HEIGHT = STAT_HEIGHT;
    private static final int GAMEOVER_BOX_POSX = 300;
    private static final int GAMEOVER_BOX_POSY = 270;
    private static final int GAMEOVER_BOX_WIDTH = 460;
    private static final int GAMEOVER_BOX_HEIGHT = 70;
    private static final int GAMEOVER_SIZE = 50;
    private static final int GAMEOVER_POSX = GAMEOVER_BOX_POSX + 5;
    private static final int GAMEOVER_POSY = GAMEOVER_BOX_POSY + GAMEOVER_SIZE;

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

    private void nextLevel() {
        maze.generate();
        hero.updateLevel();
        hero.levelUp();
        hero.initCharacter();
        monsterAmount = (int)(Math.random() * 3) + 3;

        initGame();
    }

    void displayStat(Graphics g) {
        g.setColor(Color.white);
        g.setFont(new Font("Courier", Font.PLAIN, STAT_SIZE));

        String statusTextHero = "";
        String statusTextMonster = "";

        g.fillRect(STAT_BOX_POSX, STAT_BOX_POSY, STAT_BOX_WIDTH, STAT_BOX_HEIGHT);
        g.setColor(Color.black);

        if(hero.isDead()) {
            gameOver(g);
        } else {
            statusTextHero = "Hero(Level_" + hero.getLevel() + ")HP:" + hero.healthPoint
                             + "/" + hero.maxHealthPoint
                             + "|SP:" + hero.strikePoint
                             + "|DP:"+ hero.defendPoint;

            for(Monster monster : monsterList){
                if(hero.x == monster.x && hero.y == monster.y){
                    statusTextHero = "Hero(Level_" + hero.getLevel() + ") HP:" + hero.healthPoint
                                     + "/" + hero.maxHealthPoint
                                     + "|SP:" + hero.strikePoint
                                     + "|DP:"+ hero.defendPoint;

                    statusTextMonster = "Monster(Level_" + monster.getLevel() + ")HP:"
                                       + monster.healthPoint + "/" + monster.maxHealthPoint
                                       + "|SP:" + monster.strikePoint
                                       + "|DP:"+ monster.defendPoint;
                }
            }
        }

        g.drawString(statusTextHero, STAT_POSX, STAT_HERO_POSY);

        if(statusTextMonster.length() > 0) {
            g.setColor(Color.white);
            g.fillRect(STAT_BOX_POSX, STAT_BOX_POSY + STAT_BOX_HEIGHT,
                    STAT_BOX_WIDTH, STAT_BOX_HEIGHT);
        }

        g.setColor(Color.black);
        g.drawString(statusTextMonster, STAT_POSX, STAT_MONSTER_POSY);
    }

    private void gameOver(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(GAMEOVER_BOX_POSX, GAMEOVER_BOX_POSY, GAMEOVER_BOX_WIDTH, GAMEOVER_BOX_HEIGHT);

        g.setColor(Color.RED);
        g.setFont(new Font("Courier", Font.PLAIN, GAMEOVER_SIZE));
        g.drawString("You are Dead!!!", GAMEOVER_POSX, GAMEOVER_POSY);

    }
}
