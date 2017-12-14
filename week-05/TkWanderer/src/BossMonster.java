import javax.swing.*;

public class BossMonster extends Monster{
    private final String bossImage = "boss.gif";

    BossMonster() {
        maxHealthPoint = 20 * getLevel() * d6.getRandomDice() + d6.getRandomDice();
        defendPoint = getLevel()/2 * d6.getRandomDice() + d6.getRandomDice()/2;
        strikePoint = getLevel()*d6.getRandomDice() + getLevel();
        initCharacter();
    }

    public void initCharacter(){
        ImageIcon icon = new ImageIcon(bossImage);
        image = icon.getImage();
        x = 9;
        y = 5;
    }
}
