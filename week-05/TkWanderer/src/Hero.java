import javax.swing.*;
import java.awt.event.KeyEvent;

public class Hero extends Entity {
    private String faceDown = "hero-down.gif";
    private String faceRight = "hero-right.gif";
    private String faceLeft = "hero-left.gif";
    private String faceUp = "hero-up.gif";


    Hero() {
        maxHealthPoint = 30 + 3 * d6.getRandomDice();
        defendPoint = 2 * d6.getRandomDice();
        strikePoint = 5 + d6.getRandomDice();
        initCharacter();
    }

    public void initCharacter(){
        setImage(faceDown);
        x = 0;
        y = 0;
    }

    public void move(){
        x += xstep;
        y += ystep;

        if(x < 0){
            x = 0;
        }

        if(x > 9) {
            x = 9;
        }

        if(y < 0){
            y = 0;
        }

        if(y > 10) {
            y = 10;
        }
    }


    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {
            xstep = -1;
            setImage(faceLeft);
        }

        if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
            xstep = 1;
            setImage(faceRight);
        }

        if (key == KeyEvent.VK_UP || key == KeyEvent.VK_W) {
            ystep = -1;
            setImage(faceUp);
        }

        if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) {
            ystep = 1;
            setImage(faceDown);
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


