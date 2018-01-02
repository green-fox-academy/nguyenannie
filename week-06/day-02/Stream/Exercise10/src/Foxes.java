import java.util.ArrayList;
import java.util.List;

public class Foxes {
    private List<Fox> foxes;

    Foxes() {
        foxes = new ArrayList<>();
        foxes.add(new Fox("Please", "Corsac","Green"));
        foxes.add(new Fox("BadCat", "Corsac", "Brown"));
        foxes.add(new Fox("AsBest", "Corsac","Red"));
        foxes.add(new Fox("Lagopus", "Opal", "Grey"));
        foxes.add(new Fox("Eagle", "Pampas","Green"));
        foxes.add(new Fox("Oracle", "Opal", "Red"));
        foxes.add(new Fox("DontKnow", "Pallida", "Green"));
    }

    List<Fox> getFoxes() {
        return foxes;
    }

}
