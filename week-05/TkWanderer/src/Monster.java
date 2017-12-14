import javax.swing.*;

public class Monster extends Entity {
    private int level;
    private String bossImage = "boss.gif";

    Monster() {
        maxHealthPoint = 20 * getLevel() * d6.getRandomDice() + d6.getRandomDice();
        defendPoint = getLevel()/2 * d6.getRandomDice() + d6.getRandomDice()/2;
        strikePoint = getLevel()*d6.getRandomDice() + getLevel();
        initCharacter();
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public void initCharacter(){
        ImageIcon icon = new ImageIcon(bossImage);
        image = icon.getImage();
        x = 200;
        y = 200;
    }

}
