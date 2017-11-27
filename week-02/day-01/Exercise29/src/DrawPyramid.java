import java.util.Scanner;

public class DrawPyramid {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter a number: ");
        int lineNum = input.nextInt();

        int j = 1;
        int z = lineNum - 1;

        for(int i = 0; i < lineNum; i++) {
            for (int x = z; x > 0; x --) {
                System.out.print(" ");
            }
            for (int x = 0; x < j; x++){
                System.out.print("*");
            }
            System.out.print("\n");
            j = j + 2;
            z = z - 1;
        }

    }
}
