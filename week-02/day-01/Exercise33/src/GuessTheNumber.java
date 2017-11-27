import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int storedNum = 8;
        boolean cantGuess = true;

        while(cantGuess) {
            System.out.println("Please guess a number: ");
            int userGuess = input.nextInt();

            if (userGuess == storedNum) {
                System.out.println("You found the number: 8");
                cantGuess = false;
            } else if (userGuess < storedNum) {
                System.out.println("The stored number is higher!");
            } else {
                System.out.println("The stored number is lower!");
            }
        }
    }
}
