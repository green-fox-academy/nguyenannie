import java.util.Scanner;

public class MileToKmConverter {
    public static void main(String[] args) {
        // Write a program that asks for an integer that is a distance in kilometers,
        // then it converts that value to miles and prints it
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the distance in km: ");
        int inputKm = input.nextInt();

        double inputMile = 0.621371 * inputKm;

        System.out.println("Distance in miles: " + inputMile);

    }
}
