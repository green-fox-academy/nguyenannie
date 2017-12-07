import java.util.Scanner;

public class String1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your string please: ");
        String aString = input.nextLine();
        System.out.println(replace(aString));
    }

    public static String replace(String str) {
        if (str.length() == 0) {
            return "";
        }
        if (str.charAt(0) == 'x') {
            return "y" + replace(str.substring(1, str.length()));
        } else {
            return str.charAt(0) + replace(str.substring(1, str.length()));
        }
    }
}
