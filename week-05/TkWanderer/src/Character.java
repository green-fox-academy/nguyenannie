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

    protected int x;
    protected int y;

    public Character() {
        initCharacter();
    }

    private void initCharacter() {

    }

    public void move() {}

    int getLevel() {
        return level;
    }

    void updateLevel() {
        level ++;
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

    void setImage(String file){
        ImageIcon icon = new ImageIcon(file);
        this.image = icon.getImage();
    }

    Image getImage() {
        return image;
    }

    void drawCharacter(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(getImage(),getX() * step,getY() * step,null);
    }

    void setCurrentHealthPoint(int healthPoints) {
        this.currentHealthPoint = healthPoints;
        if(this.currentHealthPoint > this.maxHealthPoint) {
            this.currentHealthPoint = this.maxHealthPoint;
        }
    }

    boolean isDead() {
        return currentHealthPoint <= 0;
    }

    double calculateStrikeValue(){
        return 2 * d6.getRandomDice() + this.strikePoint;
    }

    void attack(Character enemy) {
        if(enemy.isDead() || this.isDead()) {
            System.out.println("attack impossible");
        } else {
            double strikeValue = this.calculateStrikeValue();
            if (strikeValue > enemy.defendPoint) {
                enemy.currentHealthPoint -= strikeValue - enemy.defendPoint;
            }
        }
    }

    void getStronger(){
        maxHealthPoint += d6.getRandomDice();
        defendPoint += d6.getRandomDice();
        strikePoint += d6.getRandomDice();
    }
}
