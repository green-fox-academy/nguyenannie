import java.awt.*;
import java.util.*;
import java.awt.event.KeyEvent;
import java.util.List;

public class GameController {
    private Hero hero;
    private List<Monster> monsterList = new ArrayList<>();
    private final int monsterNum = 3;
    Map map;

    public GameController(){
        for(int i = 0; i < monsterNum - 1; i ++) {
            monsterList.add(new Monster(new Random().nextInt(10), new Random().nextInt(11),false));
        }
        monsterList.add(new Monster(new Random().nextInt(10), new Random().nextInt(11),true));
        monsterList.add(new BossMonster(new Random().nextInt(10), new Random().nextInt(11)));
        map = new Map();
        hero = new Hero();
    }

    public Hero getHero() {
        return hero;
    }
    public Monster getMonster(int i) {
        return monsterList.get(i);
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
        }
        if(heroMoved){
            for (int i = 0; i < monsterList.size(); i++) {
                monsterList.get(i).takeTurn();
            }
        }
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

}
