package Model;

import java.awt.*;
import java.util.Random;
import javax.swing.ImageIcon;

public class Characters {
    public static final int step = Tile.tileSize;

    public int maxHealthPoint;
    public int healthPoint;
    public int defendPoint;
    public int strikePoint;
    public int level = 1;

    protected Image image;

    public int x;
    public int y;

    protected Characters() {
        initCharacter();
    }

    private void initCharacter() {

    }

    public int getLevel() {
        return level;
    }

    public void updateLevel() {
        level ++;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    void setImage(String file){
        ImageIcon icon = new ImageIcon(file);
        this.image = icon.getImage();
    }

    public Image getImage() {
        return image;
    }
    /*

    @Override
    public void draw(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(getImage(),getX() * step,getY() * step,null);
    }

     */

    void setHealthPoint(int healthPoint) {
        this.healthPoint = healthPoint;
        if(this.healthPoint > this.maxHealthPoint) {
            this.healthPoint = this.maxHealthPoint;
        }
    }

    public boolean isDead() {
        return healthPoint <= 0;
    }

    int rollDice() {
        return new Random().nextInt(6) + 1;
    }

    private double calculateStrikeValue(){
        return 2 * rollDice() + this.strikePoint;
    }

    public void attack(Characters enemy) {
        if(enemy.isDead() || this.isDead()) {
            System.out.println("attack impossible");
        } else {
            double strikeValue = this.calculateStrikeValue();
            if (strikeValue > enemy.defendPoint) {
                enemy.healthPoint -= strikeValue - enemy.defendPoint;
            }
        }
    }

    public void getStronger(){
        maxHealthPoint += rollDice();
        defendPoint += rollDice();
        strikePoint += rollDice();
    }
}
