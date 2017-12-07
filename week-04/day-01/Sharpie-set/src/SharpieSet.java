import java.util.ArrayList;
import java.util.List;

public class SharpieSet {
    List<Sharpie> sharpies;
    public SharpieSet() {
        sharpies = new ArrayList<>();
    }
    public void addSharpies(Sharpie asharpie) {
        sharpies.add(asharpie);
    }

    public boolean countUsable(Sharpie sharpie) {
        boolean result = false;
        if(sharpie.inkAmount >= 0) {
                result = true;
            }
        return result;
    }

    public void removeTrash() {
        for(int i = 0; i < sharpies.size(); i++){
            if(!countUsable(sharpies.get(i))) {
                sharpies.remove(i);
            }
        }
    }
}
