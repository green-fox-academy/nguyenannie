import java.awt.*;
import javax.swing.ImageIcon;

abstract class Character {
    protected final int step = Tile.tileSize;

    protected int maxHealthPoint;
    protected int healthPoint;
    protected int defendPoint;
    protected int strikePoint;
    protected int level = 1;

    protected Image image;

    protected int x;
    protected int y;

    Character() {
        initCharacter();
    }

    private void initCharacter() {

    }

    void move() {}

    int getLevel() {
        return level;
    }

    void updateLevel() {
        level ++;
    }

    private int getX() {
        return x;
    }

    private int getY() {
        return y;
    }

    void setImage(String file){
        ImageIcon icon = new ImageIcon(file);
        this.image = icon.getImage();
    }

    private Image getImage() {
        return image;
    }

    void drawCharacter(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(getImage(),getX() * step,getY() * step,null);
    }

    void setHealthPoint(int healthPoint) {
        this.healthPoint = healthPoint;
        if(this.healthPoint > this.maxHealthPoint) {
            this.healthPoint = this.maxHealthPoint;
        }
    }

    boolean isDead() {
        return healthPoint <= 0;
    }

    int rollDice() {
        return (int)(Math.random() * 5) + 1;
    }
    private double calculateStrikeValue(){
        return 2 * rollDice() + this.strikePoint;
    }

    void attack(Character enemy) {
        if(enemy.isDead() || this.isDead()) {
            System.out.println("attack impossible");
        } else {
            double strikeValue = this.calculateStrikeValue();
            if (strikeValue > enemy.defendPoint) {
                enemy.healthPoint -= strikeValue - enemy.defendPoint;
            }
        }
    }

    void getStronger(){
        maxHealthPoint += rollDice();
        defendPoint += rollDice();
        strikePoint += rollDice();
    }
}
