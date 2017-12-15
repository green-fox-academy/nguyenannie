import javax.swing.*;
import java.awt.event.KeyEvent;
import java.util.Random;

public class Monster extends Character {
    protected int level;
    protected final String monsterImage = "skeleton.gif";
    boolean cantMove;

    Monster(){

    }

    Monster(int xc, int yc) {
        maxHealthPoint = 20 * getLevel() * d6.getRandomDice();
        defendPoint = getLevel()/2 * d6.getRandomDice();
        strikePoint = getLevel()*d6.getRandomDice();
        initCharacter(xc,yc);
    }

    public void move(){
        int newX = 0, newY = 0;

        do {
            newX = x + ranStep();
            newY = y + ranStep();
        } while(map.getTile(newX,newY).isSolid);

        x = newX;
        y = newY;
    }

    public void takeTurn(){
        if(cantMove == false) {
            move();
            cantMove = true;
        } else {
            cantMove = false;
        }

    }

    public int ranStep(){
        int r = new Random().nextInt(3);

        return r - 1;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public void initCharacter(int xc,int yc){
        ImageIcon icon = new ImageIcon(monsterImage);
        image = icon.getImage();
        x = xc;
        y = yc;
    }

}
