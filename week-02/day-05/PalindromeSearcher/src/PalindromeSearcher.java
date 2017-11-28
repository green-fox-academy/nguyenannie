import java.util.*;

public class PalindromeSearcher {
    public static void main(String[] args) {
        String input = "dog goat dad duck doodle never";
        System.out.print(palindromeSearcher(input));

    }
    public static ArrayList<String> palindromeSearcher(String input) {
        ArrayList<String> result = new ArrayList<String>();
        for(int k = 3; k < input.length(); k++) {
            for(int i = 0; i < input.length() - k + 1; i ++) {
                String substr = input.substring(i, i + k);
                if(checkPalindrome(substr) == true) {
                    result.add(substr);
                }
            }
        }
        return result;
    }

    public static boolean checkPalindrome(String stringInput) {
        if(stringInput.equals(reverseString(stringInput))) {
            return true;
        } else {
            return false;
        }
    }


    public static String reverseString(String input) {
        for (int i = 0; i < input.length(); i++) {
            input = input.substring(1, input.length() - i) + input.charAt(0) + input.substring(input.length() - i);
        }
        return input;
    }

}
