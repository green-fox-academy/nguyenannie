import java.util.Scanner;

public class AnimalsandLegs {
    public static void main(String[] args) {
        // Write a program that asks for two integers
        // The first represents the number of chickens the farmer has
        // The seconf represents the number of pigs the farmer has
        // It should print how many legs all the animals have
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the number of chickens: ");
        int inputChick = input.nextInt();

        System.out.println("Enter the number of pigs: ");
        int inputPig = input.nextInt();

        int totalLegs = inputChick * 2 + inputPig * 4;

        System.out.println("Total number of legs is: " + totalLegs);
    }
}
