import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Collection;

public class Extension {
    int add(int a, int b) {
        return a + b;
    }

    int maxOfThree(int a, int b, int c) {
       int max = a;
       if(b > max)  max = b;
       if(c > max)  max = c;
       return max;
    }

    int median(List<Integer> pool) {
        Collections.sort(pool);
        if(pool.size() % 2 != 0) {
            return pool.get((pool.size()/ 2));
        } else {
            return (pool.get(pool.size()/2) + pool.get(pool.size()/2 - 1))/2;
        }
    }

    boolean isVowel(char c) {
        return Arrays.asList('a', 'u', 'o', 'e', 'i').contains(c);
    }

    String translate(String hungarian) {
        String teve = hungarian;
        int length = teve.length();
        for (int i = 0; i < length; i++) {
            char c = teve.charAt(i);
            if (isVowel(c)) {
                teve = teve.substring(0,i) + c + "v" + c + teve.substring(i + 1, length);
                i += 2;
                length += 2;
            }
        }
        return teve;

    }
}
