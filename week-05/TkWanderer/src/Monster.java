import javax.swing.*;
import java.awt.event.KeyEvent;
import java.util.Random;

public class Monster extends Character {
    protected final String monsterImage = "skeleton.gif";
    boolean cantMove;
    private boolean hasKey;

    public Monster(){
    }

    Monster(int xc, int yc, int level, boolean hasKey) {
        this.level = level;
        maxHealthPoint = 2 * level * d6.getRandomDice();
        defendPoint = (int)Math.ceil(level * d6.getRandomDice() / 2.0);
        strikePoint = level * d6.getRandomDice();
        currentHealthPoint = maxHealthPoint;
        this.hasKey = hasKey;
        initCharacter(xc,yc);
    }

    public boolean getHasKey(){
        return this.hasKey;
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
        if(!cantMove) {
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

    public void initCharacter(int xc,int yc){
        ImageIcon icon = new ImageIcon(monsterImage);
        image = icon.getImage();
        x = xc;
        y = yc;
    }

    public void updateLevel(int x) {
        this.level = x;
    }

}
