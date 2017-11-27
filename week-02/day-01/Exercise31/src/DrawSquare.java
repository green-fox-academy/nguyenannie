import java.util.Scanner;

public class DrawSquare {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter a number: ");
        int inputNum = input.nextInt();

        for (int i = 0; i < inputNum; i++) {
            if (i == 0 || i == inputNum - 1) {
                for (int j = 0; j < inputNum; j++) {
                    System.out.print("%");
                }
            } else {
                for (int j = 0; j < inputNum; j++) {
                    if (j == 0 || j == inputNum - 1) {
                        System.out.print("%");
                    } else {
                        System.out.print(" ");
                    }
                }
            }
            System.out.print("\n");
        }
    }
}


