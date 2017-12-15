import java.awt.event.KeyEvent;

public class Hero extends Character {
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
        int newX = 0, newY = 0;

        newX = x + xstep;
        newY = y + ystep;

        if(!map.getTile(newX,newY).isSolid){
            x = newX;
            y = newY;
        }

        if(map.getTile(newX,newY).isSolid) {
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

        if(key == KeyEvent.VK_SPACE) {
            attack();
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

        if(key == KeyEvent.VK_SPACE){
            defend();
        }
    }


}


