import java.util.Scanner;

public class Bunny2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the number of Bunnies");
        int numberofBunnies = input.nextInt();
        System.out.println(bunnyWierdEar(numberofBunnies));
    }
    public static int bunnyWierdEar(int x) {
        if( x == 0) {
            return 0;
        } else if(x %2 != 0){
            return bunnyWierdEar(x - 1) + 2;
        } else {
            return bunnyWierdEar(x - 1) + 3;
        }
    }
}
