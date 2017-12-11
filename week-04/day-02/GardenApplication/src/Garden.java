import java.util.ArrayList;
import java.util.List;

public class Garden {
    List<Plant> plants;
    double waterPerPlant;
    int size;

    public Garden() {
        plants = new ArrayList<>();
        waterPerPlant = 0;
    }

    public void addPlant(Plant plant) {
        plants.add(plant);
    }

    public void printStatus() {
        for (int i = 0; i < plants.size(); i++) {
            if (plants.get(i).isNeedWater()) {
                System.out.println(plants.get(i).atype + " " + plants.get(i).color + " needs water.");
            } else {
                System.out.println(plants.get(i).atype + " " + plants.get(i).color + " doesn't need water.");
            }
        }

    }

    public int calculateDryPlants() {
        int dryPlants = 0;
        for (int i = 0; i < plants.size(); i++) {
            if (plants.get(i).needWater) {
                dryPlants += 1;
            }
        }
        return dryPlants;
    }

    public void water(double waterAmount) {
        boolean doesNeedMoreWater = true;
        waterPerPlant = (waterAmount / calculateDryPlants());
        System.out.println("Water with " + waterAmount);
        for (int i = 0; i < plants.size(); i++) {
            if (plants.get(i).needWater && doesNeedMoreWater) {
                plants.get(i).waterLevel += waterPerPlant * plants.get(i).waterAbsorbRate;
            } else {
                doesNeedMoreWater = !doesNeedMoreWater;
            }
        }
    }
}
