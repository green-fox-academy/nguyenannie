import java.awt.event.KeyEvent;

public class Hero extends Character {
    private String faceDown = "hero-down.gif";
    private String faceRight = "hero-right.gif";
    private String faceLeft = "hero-left.gif";
    private String faceUp = "hero-up.gif";

    enum Directions {
        UP, DOWN, LEFT, RIGHT;
    }

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

    public void move(Directions dir){
        int newX = x, newY = y;

        switch (dir) {
            case UP:
                newY = y - 1;
                setImage(faceUp);
                break;

            case DOWN:
                newY = y + 1;
                setImage(faceDown);
                break;

            case LEFT:
                newX = x - 1;
                setImage(faceLeft);
                break;
                
            case RIGHT:
                newX = x + 1;
                setImage(faceRight);
                break;
        }

        if(!map.getTile(newX,newY).isSolid){
            x = newX;
            y = newY;
        }

        if(map.getTile(newX,newY).isSolid) {
        }
    }

}


