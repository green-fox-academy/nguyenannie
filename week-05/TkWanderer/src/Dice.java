class Dice {
    private int randomDice;

    int getRandomDice() {
        randomDice = (int)(Math.random() * 5) + 1;
        return randomDice;
    }
}
