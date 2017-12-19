class Dice {
    private int randomDice;

    int rollDice() {
        randomDice = (int)(Math.random() * 5) + 1;
        return randomDice;
    }
}
