import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dice {
    int dice1;
    int dice2;
    int dice3;
    int dice4;
    int dice5;
    int dice6;

    List<Integer> diceList = new ArrayList<Integer>(Arrays.asList(this.dice1,this.dice2,dice3,dice4,dice5,dice6));

    public void roll() {
        for(int i = 0; i < diceList.size(); i ++) {
            this.diceList.get(i) =  (int) (Math.random()*6)+ 1;
        }
    }

    public List<Integer> getCurrent() {
        return this.diceList;
    }
}
