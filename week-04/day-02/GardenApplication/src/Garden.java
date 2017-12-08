import java.util.ArrayList;
import java.util.List;

public class Garden {
    List<Plant> plants;
    int needToBeWatered;
    int dryPlants;
    double waterPerPlant = 0;
    int size;

    public Garden() {
        plants = new ArrayList<>();
    }

    public void addPlant(Plant plant) {
        plants.add(plant);
    }

    public void printStatus(){
        for(int i = 0; i < plants.size(); i ++){
            if(plants.get(i).isNeedWater()) {
                System.out.println(plants.get(i).atype + " " + plants.get(i).color + " needs water.");
            } else {
                System.out.println(plants.get(i).atype + " " + plants.get(i).color + " doesnt need water.");
            }
        }

    }
    public int calculateDryPlants() {
        for(int i = 0; i < plants.size(); i ++) {
            if(plants.get(i).needWater) {
                dryPlants += 1;
            }
        }
        return dryPlants;
    }

    public void water(double waterAmount){
        waterPerPlant = (waterAmount / dryPlants);
        System.out.println("Water with " + waterAmount);
        for(int i = 0; i < plants.size(); i ++) {
            if(plants.get(i).needWater) {
                plants.get(i).waterLevel += waterPerPlant * plants.get(i).waterAbsorbRate;
            }
        }
    }

}
