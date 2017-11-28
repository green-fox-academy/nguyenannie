import java.util.*;

public class GuessMyNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int live = 5;
        int numberToGuess = (int) (Math.random() * 100);

        System.out.println("I've the number between 1-100. You have 5 lives");

        for(int i = 0; i < 5; i++ ) {
            System.out.println("Enter your number " + (i + 1) + " choice: ");
            int choice = input.nextInt();
            if(choice == numberToGuess && live > 0){
                System.out.println("Congratulations! You win!");
                break;
            } else if(choice < numberToGuess && live> 0){
                live = live - 1;
                if(live == 0) {
                    System.out.println("Sorry! You lose!");
                    break;
                }
                System.out.println("Too low. You have " + live + " life left.");
            } else if(choice > numberToGuess && live> 0) {
                live = live - 1;
                if(live == 0) {
                    System.out.println("Sorry! You lose!");
                    break;
                }
                System.out.println("Too high. You have " + live + " life left.");
            }
        }
    }
}
