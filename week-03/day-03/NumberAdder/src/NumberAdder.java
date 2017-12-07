import java.util.Scanner;

public class NumberAdder {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Number to add please: ");
        int number = input.nextInt();
        System.out.print(adder(number));
    }

    public static int adder(int n){
        if(n == 0) {
            return 0;
        } else {
            return adder(n - 1) + n;
        }
    }
}
