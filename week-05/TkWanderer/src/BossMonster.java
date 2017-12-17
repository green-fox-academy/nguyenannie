import javax.swing.*;

public class BossMonster extends Monster{
    private final String bossImage = "boss.gif";

    BossMonster(int xc, int yc) {
        maxHealthPoint = 20 * getLevel() * d6.getRandomDice() + d6.getRandomDice();
        defendPoint = getLevel()/2 * d6.getRandomDice() + d6.getRandomDice()/2;
        strikePoint = getLevel()*d6.getRandomDice() + getLevel();
        currentHealthPoint = maxHealthPoint;
        initCharacter(xc,yc);
    }

    public void initCharacter(int xc,int yc){
        ImageIcon icon = new ImageIcon(bossImage);
        image = icon.getImage();
        x = xc;
        y = yc;
    }
}
