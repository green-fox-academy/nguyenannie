import java.util.ArrayList;
import java.util.List;

class Fleet {
    private ArrayList<ToDo> things;

    Fleet() {
        things = new ArrayList<>();
    }

    void add(ToDo thing) {
        things.add(thing);
    }

    List<ToDo> getThings() {
        return things;
    }

    @Override
    public String toString() {
        String result = "";
        for(int i = 0; i < things.size(); i++) {
            result += (i+1) + ". " + things.get(i) + "\n";
        }
        return result;
    }
}

