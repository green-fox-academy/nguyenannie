import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class SortTheOdd {
    static int[] sortArray(int[] array) {
        List<Integer> list2 = new ArrayList<>();

        for(int element:array) {
           if(element % 2 != 0) {
               list2.add(element);
           }
        }

        Collections.sort(list2);

        int k = 0;
        for(int i = 0; i < array.length; i ++) {
            if(array[i] % 2 != 0) {
                array[i] = list2.get(k);
                k++;
            }
        }

       return array;
    }
}
