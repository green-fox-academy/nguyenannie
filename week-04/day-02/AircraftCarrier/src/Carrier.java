import java.util.ArrayList;
import java.util.List;

public class Carrier {
    List<AirCraft> airCrafts;
    private int healthPoint;
    private int ammoStorage;
    private int totalDamage;

    public Carrier(int ammoStorage, int healthPoint){
        this.ammoStorage = ammoStorage;
        this.healthPoint = healthPoint;
        airCrafts = new ArrayList<>();
    }

    public void addAircraft(String aircraftType){
        switch (aircraftType) {
            case "F16": airCrafts.add(new F16()); break;
            case "F35": airCrafts.add(new F35()); break;
        }
    }

    public int getTotalAmmoNeeded(){
        int totalAmmoNeeded = 0;
        for(int i = 0; i < airCrafts.size(); i++){
            totalAmmoNeeded += airCrafts.get(i).getAmmoNeeded();
        }
        return totalAmmoNeeded;
    }

    private void fillTypeToMax(String type) {
        for (int i = 0; i < airCrafts.size(); i++) {
            AirCraft airCraft = airCrafts.get(i);
            if (airCraft.getType().equals(type)) {
                ammoStorage = airCraft.refill(ammoStorage);
            }
        }
    }

    public void fill() throws Exception{
        if(ammoStorage == 0) {
            throw new Exception("No ammo");
        }
        if (ammoStorage < getTotalAmmoNeeded()) {
            fillTypeToMax("F35");
            fillTypeToMax("F16");
        } else {
            for (int i = 0; i < airCrafts.size(); i++) {
                ammoStorage = airCrafts.get(i).refill(ammoStorage);
            }
        }
    }

    public void fight(Carrier enemy){
        for(int i = 0; i < airCrafts.size(); i++) {
            int damage = airCrafts.get(i).fight();
            enemy.healthPoint -= damage;
            totalDamage += damage;
        }
    }

    public void getCarrierStatus(){
        if(healthPoint <= 0) {
            System.out.println("It's dead Jim :(");
        }
        System.out.println("HP: " + healthPoint +
                ", Aircraft count: " + airCrafts.size() +
                ", Ammo Storage: " + ammoStorage +
                ", Total damage: " + totalDamage);
        System.out.println("Aircrafts:");
        for(int i = 0; i < airCrafts.size(); i++){
            airCrafts.get(i).getStatus();
        }
    }

}
