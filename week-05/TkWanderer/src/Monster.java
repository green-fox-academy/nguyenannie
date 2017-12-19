import javax.swing.*;
import java.util.Random;

class Monster extends Character {
    private final String monsterImage = "skeleton.gif";
    private boolean moveLastRound;
    private boolean hasKey;

    Monster(){
    }

    Monster(int posX, int posY, int level, boolean hasKey) {
        this.level = level;
        maxHealthPoint = 2 * level * d6.getRandomDice();
        defendPoint = (int)Math.ceil(level * d6.getRandomDice() / 2.0);
        strikePoint = level * d6.getRandomDice();
        healthPoint = maxHealthPoint;
        this.hasKey = hasKey;
        initCharacter(posX,posY);
    }

    private void move(Maze maze){
        int newX, newY;

        do {
            newX = x + stepRandom();
            newY = y + stepRandom();
        } while(maze.getTile(newX,newY).orElse(Maze.WALL).isSolid);

        x = newX;
        y = newY;
    }

    void takeTurn(Maze maze){
        if(!moveLastRound) {
            move(maze);
            moveLastRound = true;
        } else {
            moveLastRound = false;
        }
    }

    private int stepRandom(){
        int r = new Random().nextInt(3);
        return r - 1;
    }

    void initCharacter(int posX,int posY){
        ImageIcon icon = new ImageIcon(monsterImage);
        image = icon.getImage();
        x = posX;
        y = posY;
    }
}
