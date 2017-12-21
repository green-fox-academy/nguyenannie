import java.util.ArrayList;
import java.util.List;

class Eureka {
    static List<Long> sumDigPow(long a, long b) {
        List<Long> result = new ArrayList<>();

        for(long i = (int) a; i < b + 1; i ++) {
            if(isEureka(i)) {
                result.add(i);
            }
        }

        return result;
    }

    static boolean isEureka(long a) {
        int k = findNumberofDigits(a);
        long sum = 0;
        long b = a;
        boolean result = false;

        for(int j = k ; j > 1;  j--) {
            sum += Math.pow(a % 10, j);
            a = a / 10;
        }

        sum += a % 10;

        if(sum == b) {
            result = true;
        }
        return result;
    }

    static int findNumberofDigits(long a) {
        int power = 1;
        while(a / 10 >= 1) {
            power++;
            a = a / 10;
        }
        return power;
    }
}
