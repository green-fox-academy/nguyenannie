import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dice {
    /*
    int dice1;
    int dice2;
    int dice3;
    int dice4;
    int dice5;
    int dice6;
    */

    List<Integer> diceList = new ArrayList<Integer>();

    public void roll() {
        for(int i = 0; i < diceList.size(); i ++) {
            //diceList.set(i, (int) (Math.random()*6)+ 1);
            this.diceList.add(i,(int) (Math.random()*6)+ 1);
        }
    }

    public List<Integer> getCurrent() {
        return this.diceList;
    }

    public void reroll() {
        for(int i = 0; i < diceList.size(); i ++) {
            this.diceList.set(i, (int) (Math.random()*6)+ 1);
        }
    }
}
