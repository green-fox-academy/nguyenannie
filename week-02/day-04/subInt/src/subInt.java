import java.util.*;

public class subInt {
    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<Integer>(Arrays.asList(1, 11, 34, 52, 61));
        int num = 1;

        System.out.print(subInt(input,num));

    }
    public static ArrayList<Integer> subInt(ArrayList<Integer> list, int num) {
        ArrayList<String> string = new ArrayList<String>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        String numString = Integer.toString(num);

        for(int i = 0; i < list.size(); i ++) {
            String inttoString = Integer.toString(list.get(i));
            string.add(inttoString);
        }

        for( int i = 0; i < string.size(); i ++) {
            String currentString = string.get(i);
            for(int j = 0; j < currentString.length(); j ++) {
                if(currentString.substring(j, j + numString.length()).equals(numString)) {
                    result.add(i);
                    break;
                }
            }
        }

        return result;
    }
}
