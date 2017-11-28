import java.util.*;

public class SubStringList {
    public static void main(String[] args) {
        ArrayList<String> input = new ArrayList<String>(Arrays.asList("this", "is", "what", "I'm", "searching", "in"));
        String elem = "ching";

        System.out.print(substrlist(input,elem));

    }
    public static int substrlist(ArrayList<String> inputList, String inputString) {
        int result = 0;
        boolean longer = false;
        boolean dobreak = false;

        for(int i = 0; i < inputList.size(); i++) {
            String searchString = inputList.get(i);

            //System.out.println(searchString);

            if(searchString.length() >= inputString.length()){
                longer = true;
            }

            for(int j = 0; j < searchString.length() - inputString.length() + 1 && longer; j ++) {
                if(searchString.substring(j,j + inputString.length()).equals(inputString)) {
                    result = i;
                    dobreak = true;
                    break;

                } else {
                    result = -1;
                }
            }
            if(dobreak) {
                break;
            }

        }

        return result;
    }
}
