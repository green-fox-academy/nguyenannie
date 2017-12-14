import javax.swing.*;

public class Monster extends Entity {
    protected int level;
    protected final String monsterImage = "skeleton.gif";

    Monster() {
        maxHealthPoint = 20 * getLevel() * d6.getRandomDice();
        defendPoint = getLevel()/2 * d6.getRandomDice();
        strikePoint = getLevel()*d6.getRandomDice();
        initCharacter();
    }

    public void move(){

    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }


    public void initCharacter(){
        ImageIcon icon = new ImageIcon(monsterImage);
        image = icon.getImage();
        x = 3;
        y = 7;
    }

}
