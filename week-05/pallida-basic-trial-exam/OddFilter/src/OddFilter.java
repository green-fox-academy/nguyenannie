import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OddFilter {

    public List<Integer> oddFilter(List<Integer> arrayList) {
        List<Integer> result = new ArrayList<>();
        for(Integer element : arrayList) {
            if(element % 2 != 0) {
                result.add(element);
            }
        }
        return result;
    }
}
