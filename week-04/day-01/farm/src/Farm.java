import java.util.ArrayList;
import java.util.List;

public class Farm {
    List<Animal> farm;
    int freeSlots;

    public Farm(){
        farm = new ArrayList<>();
    }

    public void breed() {
        if(freeSlots > 0) {
            new Animal();
        }
    }

    public void remove(){
        int fullAnimal = 0;
        for(int i = 0; i < farm.size() - 1; i ++) {
            if (farm.get(i).hunger < farm.get(i + 1).hunger) {
                fullAnimal = i;
            } else {
                fullAnimal = i + 1;
            }
        }
        farm.remove(fullAnimal);
    }
}

