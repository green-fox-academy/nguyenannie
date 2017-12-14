import javax.swing.*;

public class Monster extends Entity {
    protected int level;
    protected final String monsterImage = "skeleton.gif";

    Monster(){

    }

    Monster(int xc, int yc) {
        maxHealthPoint = 20 * getLevel() * d6.getRandomDice();
        defendPoint = getLevel()/2 * d6.getRandomDice();
        strikePoint = getLevel()*d6.getRandomDice();
        initCharacter(xc,yc);
    }

    public void move(){

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
