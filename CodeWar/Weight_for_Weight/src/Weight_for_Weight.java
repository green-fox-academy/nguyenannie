import java.util.ArrayList;
import java.util.List;

public class Weight_for_Weight {
    public static String orderWeight(String str) {
        int k = 0;

        List<String> list = new ArrayList<>();
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == ' ') {
                list.add(str.substring(k,i));
                k = i + 1;
            }
        }
        list.add(str.substring(k,str.length()));

        boolean swapped = true;
        String temp;
        int j = 0;
        while (swapped) {
            swapped = false;
            j++;
            for (int i = 0; i < list.size() - j; i++) {
                if (sumDigit(list.get(i)) > sumDigit(list.get(i + 1))) {
                    temp = list.get(i);
                    list.set(i, list.get(i + 1));
                    list.set(i + 1, temp);
                    swapped = true;
                }
            }
        }

        for(int i = 0; i < list.size() - 1; i++) {
            if (sumDigit(list.get(i)) == sumDigit(list.get(i + 1))) {
                if(isAfter(list.get(i), list.get(i + 1))) {
                    temp = list.get(i);
                    list.set(i, list.get(i + 1));
                    list.set(i + 1, temp);
                }
            }
        }

        String result = "";
        for(int i = 0; i < list.size(); i++) {
            result += list.get(i) + " ";
        }

        return result.substring(0,result.length() - 1);
    }

    public static int sumDigit(String str) {
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            sum += Character.getNumericValue(str.charAt(i));
        }
        return sum;
    }

    public static boolean isAfter(String str1, String str2) {
        int l;
        boolean result = false;
        String str = " ";
        if(str1.length() > str2.length()) {
            l = str2.length();
        } else {
            l = str1.length();
        }
        for(int i = 0; i < l; i++) {
            if (str1.charAt(i) > str2.charAt(i)) {
                result = true;
                break;
            }
        }

        return result;
    }
}