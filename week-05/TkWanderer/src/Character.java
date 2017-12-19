import java.awt.*;
import javax.swing.ImageIcon;

public abstract class Character {
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

    public Character() {
        initCharacter();
    }

    private void initCharacter() {

    }

    public void move() {

    }

    public void setLevel(int level) {
        this.level = level;
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

    public void setCurrentHealthPoint(int healthPoints) {
        this.currentHealthPoint = healthPoints;
        if(this.currentHealthPoint > this.maxHealthPoint) {
            this.currentHealthPoint = this.maxHealthPoint;
        }
    }

    public boolean isDead() {
        return currentHealthPoint <= 0;
    }

    public double calculateStrikeValue(){
        return 2 * d6.getRandomDice() + this.strikePoint;
    }

    public void attack(Character enemy) {
        if(enemy.isDead() || this.isDead()) {
            System.out.println("attack impossible");
        } else {
            double strikeValue = this.calculateStrikeValue();
            if (strikeValue > enemy.defendPoint) {
                enemy.currentHealthPoint -= strikeValue - enemy.defendPoint;
            }
        }
    }

    public void getStronger(){
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
