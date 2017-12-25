import java.awt.*;

public class Display extends GameController{
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