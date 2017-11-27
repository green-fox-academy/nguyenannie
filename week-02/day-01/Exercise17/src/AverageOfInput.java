import java.util.Scanner;

public class AverageOfInput {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int sum = 0;
        for( int i = 0; i< 5; i++) {
            System.out.println("Please enter an integer: ");
            int input1 = input.nextInt();
            sum = sum + input1;
        }

        double average = sum/5.0;

        System.out.println("The average is:" + average);
    }
}
