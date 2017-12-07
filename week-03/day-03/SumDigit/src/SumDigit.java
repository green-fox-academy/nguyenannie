import java.util.Scanner;

public class SumDigit {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your number: ");
        int number = input.nextInt();
        System.out.print(sumdigit(number));
    }
    public static int sumdigit(int n) {
        if(n / 10 < 1) {
            return n;
        } else {
            return sumdigit(n /10) + n % 10;
        }
    }
}
