import java.util.ArrayList;
import java.util.List;

public class Carrier {
    List<AirCraft> airCrafts;
    int healthPoint;
    int totalAmmoNeeded;
    F16 f16 = new F16();
    F35 f35 = new F35();

    public Carrier(){
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
            airCrafts.get(i).ammoNeeded = airCrafts.get(i).ammoStore - airCrafts.get(i).maxAmmo;
            if(airCrafts.get(i).ammoNeeded < 0){
                totalAmmoNeeded += airCrafts.get(i).maxAmmo - airCrafts.get(i).ammoStore;
            }
        }
        return totalAmmoNeeded;
    }

    public void fill(int addingAmmo){
        if(addingAmmo < totalAmmoNeeded) {
            for (int i = 0; i < airCrafts.size(); i++) {
                if (airCrafts.get(i).ammoNeeded < 0 && airCrafts.get(i).type.equals("F35") && addingAmmo > 0) {
                    airCrafts.get(i).ammoStore += airCrafts.get(i).ammoNeeded;
                    addingAmmo -= airCrafts.get(i).ammoNeeded;
                }
            }
            for (int i = 0; i < airCrafts.size(); i++) {
                if (airCrafts.get(i).ammoNeeded < 0 && airCrafts.get(i).type.equals("F16") && addingAmmo > 0) {
                    airCrafts.get(i).ammoStore += airCrafts.get(i).ammoNeeded;
                    addingAmmo -= airCrafts.get(i).ammoNeeded;
                }
            }
        } else {
            for (int i = 0; i < airCrafts.size(); i++) {
                if (airCrafts.get(i).ammoNeeded < 0 && addingAmmo > 0) {
                    airCrafts.get(i).ammoStore += airCrafts.get(i).ammoNeeded;
                    addingAmmo -= airCrafts.get(i).ammoNeeded;
                }
            }
        }

    }

}
