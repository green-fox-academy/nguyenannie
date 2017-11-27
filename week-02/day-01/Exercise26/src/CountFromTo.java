import java.util.Scanner;

public class CountFromTo {
    // Create a program that asks for two numbers
    // If the second number is not bigger than the first one it should print:
    // "The second number should be bigger"
    //
    // If it is bigger it should count from the first number to the second by one
    //
    // example:
    //
    // first number: 3, second number: 6, should print:
    //
    // 3
    // 4
    // 5

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter the first number: ");
        int input1 = input.nextInt();

        System.out.println("Please enter the second number: ");
        int input2 = input.nextInt();

        if(input2 <= input1){
            System.out.println("The second number should be bigger");
        } else {
            for( int i = input1; i < input2; i++) {
                System.out.println(i);
            }
        }
    }
}
