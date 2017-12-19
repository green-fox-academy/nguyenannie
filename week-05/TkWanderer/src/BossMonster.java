import javax.swing.*;

class BossMonster extends Monster{
    private final String bossImage = "boss.gif";

    BossMonster(int xc, int yc, int level) {
        this.level = level;
        maxHealthPoint = 2 * level * d6.getRandomDice() + d6.getRandomDice();
        defendPoint = (int)Math.ceil(level/2.0 * d6.getRandomDice() + d6.getRandomDice()/2.0);
        strikePoint = level * d6.getRandomDice() + getLevel();
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
