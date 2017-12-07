import java.util.Scanner;

public class Power {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your base number: ");
        int base = input.nextInt();
        System.out.println("Enter your power number: ");
        int power = input.nextInt();
        System.out.println(power(base, power));
    }

    public static int power(int x, int y){
        if(x == 0) {
            return 0;
        } else if(x == 1 || y == 0){
            return 1;
        } else {
            return power(x,y - 1) * x;
        }
    }
}
