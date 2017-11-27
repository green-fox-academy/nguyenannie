import java.util.Scanner;

public class ParametricAverage {
    public static void main(String[] arg) {
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter the number of integers you want as a input: ");
        int a = input.nextInt();

        int sum = 0;

        for (int i = 0; i < a; i ++) {
            System.out.println("enter an integer u want: ");
            int b = input.nextInt();
            sum += b;
        }
        System.out.println("Sum: " + sum);
        float average = ((float) sum) / a;
        System.out.println("Average " + average);
    }
}
