import java.util.Scanner;

public class DivideByZero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the divisor: ");
        int divisor = scanner.nextInt();

        try { // Prevents the program breaking when attempting dividing by zero
            int result = 10 / divisor;
            System.out.println("The result is: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Can't divide by zero!");
        }
    }
}
