import java.util.*;

public class Unique {
    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<Integer>(Arrays.asList(7,9,10,7,3,4,7,10));

        System.out.print(unique(input));

    }

    public static ArrayList<Integer> unique(ArrayList<Integer> origin) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i = 0; i < origin.size(); ++i) {
            // check if result contains origin[i] yet
            boolean contains = false;
            for(int j = 0; j < result.size() && !contains; ++j) {
                if(result.get(j).equals(origin.get(i))) {
                    contains = true;
                }
            }
            // if doesn't contain yet then add
            if(!contains) {
                result.add(origin.get(i));
            }
        }
        return result;
    }
}
