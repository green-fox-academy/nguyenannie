import java.util.*;

public class PalindromeBuilder {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the string you want to build a palindrome:");
        String inputString = input.nextLine();

        String result = palindromeBuilder(inputString);
        System.out.print("The palindrome is: \n" + result);

    }

    public static String palindromeBuilder(String s1) {
        String s2 = reverseString(s1);
        return s1 + s2;

    }


    public static String reverseString(String input) {
        for (int i = 0; i < input.length(); i++) {
            input = input.substring(1, input.length() - i) + input.charAt(0) + input.substring(input.length() - i);
        }
        return input;
    }
}
