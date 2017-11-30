import com.sun.deploy.util.ArrayUtil;
import com.sun.tools.javac.util.ArrayUtils;

import java.nio.file.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.*;

public class Lottery {
    public static void main(String[] args) {
        int[] in = {10,10,9,8,7,6,10,10,10,10,9,9,9,8,8,8,7,7,7,6,14,15,16,17};
        System.out.print(findMostPopular(in));
        /*
        String[] k = in.split(";");
        ArrayList<String> n = new ArrayList<String>(k);
        System.out.print(k);
        */
    }

    public static int[] findLottery(String pathName){
        try {
            Path path = Paths.get(pathName);
            List<String> data = Files.readAllLines(path);
            List<int[]> splitData = new ArrayList<int[]>();

            for(int i = 0; i < data.size(); i++){
                String newLine = splitString(data.get(i));
                String newDataLine = makeitSmall(newLine);
                int[] arrayInput = stringToInt(newDataLine);
                splitData.add(arrayInput);
            }
            int[] concat1 = joinArray(splitData.get(0),splitData.get(1));
            ArrayList<int[]> aConcat = new ArrayList<int[]>();
            for(int i = 2; i < splitData.size() - 2; i ++){
                int[] concat2 = joinArray(concat1,splitData.get(i));
                aConcat.set(0,concat2);
            }
            int[] concatFinal = aConcat.get(0);
            int[] result = findMostPopular(concatFinal);
            return result;

        } catch(Exception e){
            System.out.print(e);
        }

    }

    public static String splitString(String inputLine){
        StringBuilder aString = new StringBuilder(inputLine);
        int k = 0;
        for(int i = 0; i < inputLine.length(); i++) {
            k = k + 1;
            if(inputLine.charAt(i) == ';') {
                aString.replace(i, i + 1, " ");
            }
        }
        return aString.toString();

    }

    public static String makeitSmall(String aString) {
        String result =  aString.substring(aString.length() - 14);
        if (result.charAt(0) == ' ') {
            result = result.substring(1);
        }
        return result;
    }

    public static int[] stringToInt(String aString) {
        List<Integer> alist = new ArrayList<Integer>();
        for (int i = 0; i < aString.length(); i++) {
            if (aString.charAt(i) == ' ') {
                if (aString.length() < 14) {
                    String bString = aString.substring(i - 1, i);
                    int newInt = Integer.parseInt(bString);
                    alist.add(newInt);
                } else {
                    String bString = aString.substring(i - 2, i);
                    int newInt = Integer.parseInt(bString);
                    alist.add(newInt);
                }
            }
        }
        int[] ret = new int[alist.size()];
        for (int k = 0; k < ret.length; k++) {
            ret[k] = alist.get(k);
        }
        return ret;
    }

    public static int[] joinArray(int[]... arrays) {
        int length = 0;
        for (int[] array : arrays) {
            length += array.length;
        }

        final int[] result = new int[length];

        int offset = 0;
        for (int[] array : arrays) {
            System.arraycopy(array, 0, result, offset, array.length);
            offset += array.length;
        }

        return result;
    }


    public static int[] findMostPopular(int[] intList) {
        ArrayList<Integer> aList = new ArrayList<>();
        ArrayList<Integer> bList = new ArrayList<>();
        int numberMax = 0;
        int count  = 0;
        int countMax = 0;
        int index = 0;
        for(int k = 0; k < 5; k ++) {
            for (int i = 0; i < intList.length; i++) {
                aList.add(intList[i]);
            }
            for (int i = 0; i < aList.size(); i++) {

                for (int j = 1; j < aList.size(); j++) {
                    if (aList.get(i).equals(aList.get(j))) {
                        aList.remove(j);
                        count = count + 1;
                    }
                    if (count > countMax) {
                        countMax = count;
                        numberMax = aList.get(i);
                        index = i;
                    }
                }
            }
            aList.remove(index);
            bList.add(numberMax);
        }

        int[] result = new int[5];
        for(int i = 0; i < 5; i ++) {
            result[i] = bList.get(i);
        }
        return result;
    }

}
