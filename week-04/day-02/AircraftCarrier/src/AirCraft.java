public class AirCraft {
    int ammoStore;
    int maxAmmo;
    int baseDemage;
    int demage;
    String type;
    boolean isEmpty;
    int ammoNeeded;

    public AirCraft() {
        ammoStore = 0;
    }

    public int fight(){
        demage = baseDemage * ammoStore;
        ammoStore = 0;
        return demage;
    }

    public int refill(int ammoFilling){
        ammoFilling -= maxAmmo;
        ammoStore += ammoFilling;
        return ammoFilling;
    }

    public String getType(){
        return this.type;
    }

    public void getStatus(){
        System.out.println("Type " +  type + ", " + "Ammo: " + ammoStore + ", " + "Base Damage: " + baseDemage + ", "+ "All Damage: " + demage + ".");
    }

    public boolean isEmpty() {
        if (ammoStore == 0) {
            isEmpty = true;
        } else {
            isEmpty = false;
        }
        return isEmpty;
    }

}
