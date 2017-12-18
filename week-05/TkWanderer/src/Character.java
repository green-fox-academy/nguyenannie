import java.awt.*;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Character {
    protected final int step = Tile.tileSize;

    protected int maxHealthPoint;
    protected int currentHealthPoint;
    protected int defendPoint;
    protected int strikePoint;
    protected int level = 1;
    protected Dice d6 = new Dice();

    protected Image image;
    protected String fileName;

    protected int x;
    protected int y;

    Map map = new Map();

    public Character() {

        initCharacter();
    }

    private void initCharacter() {

    }

    public void move() {

    }

    public int getLevel() {
        return level;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    public void setImage(String file){
        ImageIcon icon = new ImageIcon(file);
        this.image = icon.getImage();
    }

    public String getFileName() {
        return fileName;
    }

    public Image getImage() {
        return image;
    }


    public void drawCharacter(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(getImage(), getX()*step, getY()*step, null);
    }

    public boolean isDead() {
        return currentHealthPoint <= 0;
    }

    public int calculateStrikeValue(){
        return 2 * d6.getRandomDice() + this.strikePoint;
    }

    public boolean attackSucceeds(Character enemy) {
        if(this.calculateStrikeValue() > enemy.defendPoint) {
            return true;
        } else {
            this.currentHealthPoint -= enemy.calculateStrikeValue() - this.defendPoint;
            return false;
        }
    }

    public void attack(Character enemy) {
        if(enemy.isDead() || this.isDead()) {
            System.out.println("target dead");
        } else {
            if (attackSucceeds(enemy)) {
                enemy.currentHealthPoint -= this.calculateStrikeValue() - enemy.defendPoint;
                this.leveling();
            } else {
                this.currentHealthPoint -= enemy.calculateStrikeValue() - this.defendPoint;
                enemy.leveling();
            }
        }
    }

    public void leveling(){
        maxHealthPoint += d6.getRandomDice();
        defendPoint += d6.getRandomDice();
        strikePoint += d6.getRandomDice();
    }

    public Rectangle getBounds(){
        return new Rectangle(getX(),getY(),getImage().getWidth(null),getImage().getHeight(null));
    }

    public boolean inBound(){
        boolean result = true;
        if(this.getBounds().intersectsLine(0,0,600,0)){
            result = false;
        }
        return result;
    }

}


/*
=======================================================================================================
0001010000
0001010110
0111010110
0000010000
1111011110
0101000010
0101011010
0000011010
0111000010
0001011010
0101010000
System.out.println("attacking " + enemy.x + ", " + enemy.y);
System.out.println("hp before " + enemy.currentHealthPoint + " hp hero " + this.currentHealthPoint);
System.out.println("hp after " + enemy.currentHealthPoint + " hp hero " + this.currentHealthPoint);
 */