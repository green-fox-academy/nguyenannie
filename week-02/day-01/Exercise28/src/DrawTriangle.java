import java.util.Scanner;

public class DrawTriangle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter a number: ");
        int inputNum = input.nextInt();

        for (int i = 0; i < inputNum; i++) {
            for(int j = 0; j < i + 1; j ++) {
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }
}
