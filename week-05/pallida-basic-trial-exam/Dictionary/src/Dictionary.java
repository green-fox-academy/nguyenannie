import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Dictionary {
    Map<String,String> map;

    Dictionary() {
        map = new HashMap<String,String>();
        map.put("alma", "apple");
        map.put("fa", "tree");
    }

    void addWord(String hunWord, String engWord) {
        map.put(hunWord,  engWord);
    }

    void removeWord(String hunWord) {
        map.remove(hunWord);
    }

    String translateToHun(String engWord) {
        String hunWord = "";
        Iterator i = map.entrySet().iterator();
        while(i.hasNext()) {
            Map.Entry me = (Map.Entry)i.next();
            if(engWord.equals(me.getValue().toString())) {
                hunWord = me.getKey().toString();
                break;
            }
        }
        return hunWord;
    }

    String translateToEng(String hunWord) {
        return map.get(hunWord);
    }
}
