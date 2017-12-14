public class Dice {
    private int randomDice;

    Dice(){
        randomDice = (int)(Math.random() * 6) + 1;
    }

    public int getRandomDice() {
        return randomDice;
    }
}
