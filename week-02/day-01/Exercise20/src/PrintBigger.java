import java.util.Scanner;

public class PrintBigger {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter the first number: ");
        int input1 = input.nextInt();

        System.out.println("Please enter the second number: ");
        int input2 = input.nextInt();

        if (input1 > input2) {
            System.out.println("The bigger number is: " + input1);
        } else if (input1 < input2) {
            System.out.println("The bigger number is: " + input2);
        } else {
            System.out.println("Two numbers are equal to: " + input1);
        }
    }
}
