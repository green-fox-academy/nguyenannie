import java.awt.*;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Character {
    protected final int step = Tile.tileSize;

    protected int maxHealthPoint;
    protected int currentHealthPoint;
    protected int defendPoint;
    protected int strikePoint;
    protected Dice d6 = new Dice();
    protected boolean isDead;

    protected Image image;
    protected String fileName;

    protected int xstep;
    protected int ystep;
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


    public void keyPressed(KeyEvent e) {

    }

    public void keyReleased(KeyEvent e) {

    }

    public void drawCharacter(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(getImage(), getX()*step, getY()*step, null);
    }


    public boolean isDead() {
        if(currentHealthPoint <= 0){
            isDead = true;
        } else {
            isDead = false;
        }
        return isDead;
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

    public int calculateStrikeValue(){
        return 2 * d6.getRandomDice() + strikePoint;
    }

    public boolean canAttack(Character enemy) {
        if(this.calculateStrikeValue() > enemy.defendPoint) {
            return true;
        } else {
            return false;
        }
    }

    public void attack() {

    }

    public void defend(){

    }

    public void leveling(){
        maxHealthPoint += d6.getRandomDice();
        defendPoint += d6.getRandomDice();
        strikePoint += d6.getRandomDice();
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
 */