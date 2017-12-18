import java.awt.*;
import java.util.*;
import java.awt.event.KeyEvent;
import java.util.List;

public class GameController {
    private Hero hero;
    private List<Monster> monsterList;
    private int monsterNum;
    Monster keyMonster;
    BossMonster boss;

    Map map;

    public GameController(){
        monsterNum = 3;
        initGame();
        map = new Map();
        hero= new Hero();
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

    public Map getMap() {
        return map;
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();
        boolean heroMoved = false;

        switch (key) {
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A:
                hero.move(Hero.Directions.LEFT);
                heroMoved = true;
                break;

            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                hero.move(Hero.Directions.RIGHT);
                heroMoved = true;
                break;

            case KeyEvent.VK_UP:
            case KeyEvent.VK_W:
                hero.move(Hero.Directions.UP);
                heroMoved = true;
                break;

            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
                hero.move(Hero.Directions.DOWN);
                heroMoved = true;
                break;

            case KeyEvent.VK_SPACE:
                for(int i = 0; i < monsterList.size(); i ++) {
                    if (monsterList.get(i).x == hero.x && monsterList.get(i).y == hero.y) {
                        hero.attack(monsterList.get(i));
                        if(monsterList.get(i).isDead()){
                            monsterList.remove(i);
                        } else {
                            monsterList.get(i).attack(hero);
                        }
                    }
                }
        }

        if(heroMoved){
            for (int i = 0; i < monsterList.size(); i++) {
                monsterList.get(i).takeTurn();
            }
        }

        if(keyMonster.isDead() && boss.isDead()) {
            update();
        }

        if(monsterList.size() == 0) {
            update();
        }

        if(hero.isDead()) {
            //reset();
        }
    }

    public void update() {
        hero.updateLevel();
        hero.levelUp();
        hero.initCharacter();
        monsterNum = (int)(Math.random() * 3) + 3;

        initGame();

        for(int i = 0; i < monsterList.size(); i ++) {
            monsterList.get(i).updateLevel(hero.level);
        }
    }

    public void initGame() {
        monsterList = new ArrayList<>();

        for(int i = 0; i < monsterNum - 2; i ++) {
            monsterList.add(new Monster(new Random().nextInt(10), new Random().nextInt(11), false));
        }

        keyMonster = new Monster(new Random().nextInt(10), new Random().nextInt(11),true);
        boss = new BossMonster(new Random().nextInt(10), new Random().nextInt(11));

        monsterList.add(keyMonster);
        monsterList.add(boss);
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

    public void drawInfo(Graphics g) {
        g.setColor(Color.white);
        g.setFont(new Font("Serif", Font.PLAIN, 15));

        String statusTextHero;
        String statusTextMonster = "";

        g.fillRect(430, 0, 280, 20);
        g.setColor(Color.black);

        if(hero.isDead()) {
            statusTextHero = "DEAD";
        } else {
            statusTextHero = "Hero (Level " + hero.getLevel() + ") HP:  " + hero.currentHealthPoint + "/" + hero.maxHealthPoint
                             + " | SP:  " + hero.strikePoint
                             + " | DP:  "+ hero.defendPoint;

            for(int i = 0; i < monsterList.size(); i ++){
                if(hero.x == monsterList.get(i).x && hero.y == monsterList.get(i).y){
                    statusTextHero = "Hero (Level " + hero.getLevel() + ") HP: " + hero.currentHealthPoint + "/" + hero.maxHealthPoint
                                     + " | SP: " + hero.strikePoint
                                     + " | DP: "+ hero.defendPoint;

                    statusTextMonster = "Monster (Level " + monsterList.get(i).getLevel() + ") HP: "
                                       + monsterList.get(i).currentHealthPoint + "/" + monsterList.get(i).maxHealthPoint
                                       + " | SP: " + monsterList.get(i).strikePoint
                                       + " | DP: "+ monsterList.get(i).defendPoint;
                }
            }
        }

        g.drawString(statusTextHero, 430, 15);

        if(statusTextMonster.length() > 0){
            g.setColor(Color.white);
            g.fillRect(430, 20, 280, 20);
        }
        g.setColor(Color.black);
        g.drawString(statusTextMonster,430,30);
    }
}
