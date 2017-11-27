import java.util.Scanner;

public class DrawDiamond {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter a number: ");
        int lineNum = input.nextInt();

        int j = 1;
        int z = lineNum/2;

        for(int i = 0; i < lineNum / 2 + 1; i++) {
            for (int x = z; x > 0; x--) {
                System.out.print(" ");
            }
            for (int x = 0; x < j; x++) {
                System.out.print("*");
            }
            System.out.print("\n");
            j = j + 2;
            z = z - 1;
        }

        int k = lineNum - 2;
        int q = 1;
        for ( int i = lineNum/2 + 1; i < lineNum; i ++ ) {
            for( int x = 0; x < q; x++) {
                System.out.print(" ");
            }
            for(int x = k; x > 0;x-- ){
                System.out.print("*");
            }
            System.out.print("\n");
            k = k - 2;
            q = q + 1;
        }
    }
}
