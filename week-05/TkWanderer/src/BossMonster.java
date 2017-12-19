import javax.swing.*;

class BossMonster extends Monster{
    private final String bossImage = "boss.gif";

    BossMonster(int xc, int yc, int level) {
        this.level = level;
        maxHealthPoint = 2 * level * d6.rollDice() + d6.rollDice();
        defendPoint = (int)Math.ceil(level/2.0 * d6.rollDice() + d6.rollDice()/2.0);
        strikePoint = level * d6.rollDice() + getLevel();
        healthPoint = maxHealthPoint;
        initCharacter(xc,yc);
    }

    void initCharacter(int posX, int posY){
        ImageIcon icon = new ImageIcon(bossImage);
        image = icon.getImage();
        x = posX;
        y = posY;
    }
}
