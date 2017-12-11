import java.util.ArrayList;
import java.util.List;

public class Armada {
    List<Ship> ships;

    public Armada() {
        ships = new ArrayList<>();
    }

    public boolean war(Armada anotherArmada) {
        int index1 = 0;
        int index2 = 0;
        boolean result;
        while(index1 < this.ships.size() && index2 < anotherArmada.ships.size()) {
            for (int i = 0; i < this.ships.size(); i++) {
                if (this.ships.get(index1).battle(anotherArmada.ships.get(index2))) {
                    index2 += 1;
                } else {
                    index1 += 1;

                }
            }
        }
        if(this.ships.size() - index1 > anotherArmada.ships.size() - index2){
            result = true;
        } else {
            result = false;
        }
        return result;
    }
}

