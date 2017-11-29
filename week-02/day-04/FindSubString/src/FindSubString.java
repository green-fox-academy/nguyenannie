import java.util.*;

public class FindSubString {
    public static void main(String[] args) {
        /*String s1 = "this is what I'm searching in";
        String s2 = "searching";
        */
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter your string: ");
        String string1 = input.nextLine();

        System.out.println("Please enter the second string you wanna find in the first string: ");
        String string2 = input.nextLine();

        System.out.println("The the starting index where the second string is starting in the first one is: ");
        System.out.print(findSubString(string1,string2));

    }
    public static int findSubString(String one,String two) {
        int k = 0;
        for(int i= 0; i < one.length() - two.length() + 1; i++) {
            if(one.substring(i, i + two.length()).equals(two)) {
                k = i;
                break;
            } else {
                k = -1;
            }
        }
        return k;
    }
}
