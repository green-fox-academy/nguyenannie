import java.util.ArrayList;
import java.util.List;

class FindShortestWord {
    static int findShort(String s) {
        List<String> list = new ArrayList<>();
        int index = 0;

        for(int i = 0; i < s.length(); i ++) {
            if(s.charAt(i) == ' ') {
                list.add(s.substring(index, i));
                index = i + 1;
            }
        }
        list.add(s.substring(index,s.length()));

        int shortest = list.get(0).length();

        for(int i = 1; i < list.size() - 1; i++) {
            if(shortest > list.get(i).length()) {
                shortest = list.get(i).length();
            }
        }

        return shortest;
    }

}
