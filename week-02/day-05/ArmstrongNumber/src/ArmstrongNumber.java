import java.util.*;

public class ArmstrongNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter a number that you want to check: ");
        int inputNum = input.nextInt();

        if(checkArmstrongNumber(inputNum)) {
            System.out.println("The " + inputNum + " is an Armstrong number.");
        } else {
            System.out.print("The " + inputNum + " is not an Armstrong number.");
        }

    }
    public static boolean checkArmstrongNumber(int num) {
        int remainder = 0;
        int num1 = num;
        int sum = 0;
        String length = Integer.toString(num);
        int power = length.length();

        while(num /10 > 0){
            remainder  = num % 10;
            sum = sum + (int) Math.pow(remainder, power);
            num = (num - remainder)/10;
            if(num < 10){
                sum = sum + (int) Math.pow(num, power);
            }
        }

        if(sum == num1) {
            return true;
        } else {
            return false;
        }
    }
}
