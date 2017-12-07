import java.util.Scanner;

public class Bunny1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of Bunnies");
        int numberofBuns = input.nextInt();

        System.out.println(bunnyEar(numberofBuns));

    }
    public static int bunnyEar(int b){
        if(b == 0) {
            return 0;
        } else {
            return bunnyEar(b -1)  + 2;
        }
    }
}
