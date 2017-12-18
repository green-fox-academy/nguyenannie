public class Dice {
    private int randomDice;

    Dice(){
        randomDice = (int)(Math.random() * 5) + 1;
    }

    public int getRandomDice() {
        return randomDice;
    }
}
