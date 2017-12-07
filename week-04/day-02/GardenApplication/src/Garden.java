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
        size = plants.size();
    }

    public void addPlant(Plant plant) {
        plants.add(plant);
    }

    public void printStatus(){
        for(int i = 0; i < size; i ++){
            if(plants.get(i).isNeedWater()) {
                System.out.println(plants.get(i).atype + " " + plants.get(i).color + " needs water.");
            } else {
                System.out.println(plants.get(i).atype + " " + plants.get(i).color + " doesnt need water.");
            }
        }

    }
    public int calculateDryTrees() {
        for(int i = 0; i < plants.size(); i ++) {
            if(plants.get(i).needWater) {
                dryPlants += 1;
            }
        }
        return dryPlants;
    }

    public double waterWith40(){
        waterPerPlant = (40.0 / dryPlants);
        return waterPerPlant;
    }

    public double waterWith70() {
        waterPerPlant = (70.0 / dryPlants);
        return waterPerPlant;
    }

}
