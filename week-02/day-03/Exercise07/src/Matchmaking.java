import java.util.Arrays;
import java.util.ArrayList;

public class Matchmaking {
    public static void main(String[] args) {
        ArrayList<String> girls = new ArrayList<String>(Arrays.asList("Eve","Ashley","Bözsi","Kat","Jane"));
        ArrayList<String> boys = new ArrayList<String>(Arrays.asList("Joe","Fred","Béla","Todd","Neef","Jeff"));
        ArrayList<String> order = new ArrayList<String>();

        // Join the two lists by matching one girl with one boy in the order list
        // Exepected output: "Eve", "Joe", "Ashley for(int i = 0; i < girls.size(); i++) {
        int i = 0;
        int j = 1;

        order = girls;

        while (j <order.size() + 1) {
            order.add(j, boys.get(i));
            i = i + 1;
            j = j+ 2;
        }

        System.out.println(order);
    }
}
