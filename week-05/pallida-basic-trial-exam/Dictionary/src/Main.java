import java.util.Iterator;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        dictionary.addWord("Szia","hello");
        dictionary.removeWord("Szia");

        Iterator i = dictionary.map.entrySet().iterator();
        while(i.hasNext()) {
            Map.Entry me = (Map.Entry)i.next();
            System.out.println(me.getKey() + " : " + me.getValue());
        }

        System.out.println(dictionary.translateToEng("fa"));
        System.out.println(dictionary.translateToHun("apple"));
    }

}
