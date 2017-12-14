import java.awt.*;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public abstract class Entity {
    protected final int step = 50;

    protected int maxHealthPoint;
    protected int currentHealthPoint;
    protected int defendPoint;
    protected int strikePoint;
    protected Dice d6 = new Dice();
    protected boolean isDead;

    protected int xstep;
    protected int ystep;
    protected int x;
    protected int y;
    protected Image image;
    protected String fileName;

    public Entity() {

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

    public void setFileName(String file){
        this.fileName = file;
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
        g2d.drawImage(getImage(), getX(), getY(), null);
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

}