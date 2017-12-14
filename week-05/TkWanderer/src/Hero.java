import javax.swing.*;
import java.awt.event.KeyEvent;

public class Hero extends Entity {
    private String faceDown = "hero-down.gif";

    Hero() {
        maxHealthPoint = 30 + 3 * d6.getRandomDice();
        defendPoint = 2 * d6.getRandomDice();
        strikePoint = 5 + d6.getRandomDice();
        initCharacter();
    }

    public void move(){
        x += xstep;
        y += ystep;

        if(x < 0){
            x = 0;
        }

        if(x > 600 - image.getWidth(null)) {
            x = 600 - image.getWidth(null);
        }

        if(y < 0){
            y = 0;
        }

        if(y > 600 - image.getHeight(null) - 20) {
            y = 600 - image.getHeight(null) - 20;
        }
    }

    public void initCharacter(){
        ImageIcon icon = new ImageIcon(faceDown);
        image = icon.getImage();
        x = 0;
        y = 0;
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {
            xstep = -step;
        }

        if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
            xstep = step;
        }

        if (key == KeyEvent.VK_UP || key == KeyEvent.VK_W) {
            ystep = -step;
        }

        if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) {
            ystep = step;
        }
    }

    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {
            xstep = 0;
        }

        if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
            xstep = 0;
        }

        if (key == KeyEvent.VK_UP || key == KeyEvent.VK_W) {
            ystep = 0;
        }

        if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) {
            ystep = 0;
        }
    }


}

