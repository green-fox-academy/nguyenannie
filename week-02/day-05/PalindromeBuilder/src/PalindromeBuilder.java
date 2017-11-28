import java.util.*;

public class PalindromeBuilder {
    public static void main(String[] args) {
        String s1 = "greenfox";
        System.out.print(palindromeBuilder(s1));

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
