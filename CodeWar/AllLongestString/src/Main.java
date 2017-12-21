public class Main {
    public static void main(String[] args) {
        /*
        Given an array of strings, return another array containing all of its longest strings.

        Example

        For inputArray = ["aba", "aa", "ad", "vcd", "aba"], the output should be
        allLongestStrings(inputArray) = ["aba", "vcd", "aba"].
         */
        String[] inputArray = {"aba", "aa", "ad", "vcd", "aba"};
        for(int i = 0; i < AllLongestString.allLongestStrings(inputArray).length; i++) {
            System.out.println(AllLongestString.allLongestStrings(inputArray)[i] + " ");
        }
    }
}
