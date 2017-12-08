import java.util.ArrayList;
import java.util.List;

public class Carrier {
    List<AirCraft> airCrafts;
    int healthPoint;
    int totalDemage;
    int totalAmmoNeeded;
    int ammoStorage;
    F16 f16 = new F16();
    F35 f35 = new F35();

    public Carrier(int ammoStorage, int healthPoint){
        this.ammoStorage = ammoStorage;
        this.healthPoint = healthPoint;
        airCrafts = new ArrayList<>();
    }

    public void addAircraft(String theType){
        if(theType.equals(f16.type)){
            airCrafts.add(f16);
        }
        if(theType.equals(f35.type)){
            airCrafts.add(f35);
        }
    }
    public int getTotalAmmoNeeded(){
        for(int i = 0; i < airCrafts.size(); i++){
            airCrafts.get(i).ammoNeeded =  airCrafts.get(i).maxAmmo - airCrafts.get(i).ammo;
            if(airCrafts.get(i).ammoNeeded > 0){
                totalAmmoNeeded += airCrafts.get(i).maxAmmo - airCrafts.get(i).ammo;
            }
        }
        return totalAmmoNeeded;
    }

    public void fill(){
            if (ammoStorage < totalAmmoNeeded) {
                for (int i = 0; i < airCrafts.size(); i++) {
                    if (airCrafts.get(i).ammoNeeded > 0 && airCrafts.get(i).type.equals("F35") && ammoStorage > 0) {
                        airCrafts.get(i).ammo += airCrafts.get(i).ammoNeeded;
                        ammoStorage -= airCrafts.get(i).ammoNeeded;
                    }
                }
                for (int i = 0; i < airCrafts.size(); i++) {
                    if (airCrafts.get(i).ammoNeeded > 0 && airCrafts.get(i).type.equals("F16") && ammoStorage > 0) {
                        airCrafts.get(i).ammo += airCrafts.get(i).ammoNeeded;
                        ammoStorage -= airCrafts.get(i).ammoNeeded;
                    }
                }
            } else {
                for (int i = 0; i < airCrafts.size(); i++) {
                    if (airCrafts.get(i).ammoNeeded > 0 && ammoStorage > 0) {
                        airCrafts.get(i).ammo += airCrafts.get(i).ammoNeeded;
                        ammoStorage -= airCrafts.get(i).ammoNeeded;
                    }
                }
            }
    }

    public void fight(Carrier enemy){
        for(int i = 0; i < airCrafts.size(); i++) {
            airCrafts.get(i).ammo = 0;
            healthPoint -= airCrafts.get(i).demage;
        }
    }

    public int getTotalDemage(){
        for(int i = 0; i < airCrafts.size(); i++) {
            totalDemage += airCrafts.get(i).demage;
        }
        return totalDemage;
    }

    public void getCarrierStatus(){
        if(healthPoint <= 0) {
            System.out.println("It's dead Jim :(");
        }
        System.out.println("HP: " + healthPoint + ", Aircraft count: " + airCrafts.size() + ", Amo Storage: " + ammoStorage + ", Total demage: " + totalDemage);
        System.out.println("Aircrafts:");
        for(int i = 0; i < airCrafts.size(); i++){
            airCrafts.get(i).getStatus();
        }
    }

}
