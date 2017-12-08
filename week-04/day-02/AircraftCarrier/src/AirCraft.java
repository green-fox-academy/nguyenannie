public class AirCraft {
    int ammo;
    int maxAmmo;
    int baseDemage;
    int demage;
    String type;
    boolean isEmpty;
    int ammoNeeded = 0;

    public AirCraft() {
        ammo = 0;
    }

    public int fight(){
        demage = baseDemage * ammo;
        ammo = 0;
        return demage;
    }

    public int refill(int ammoFilling){
        ammoFilling -= (maxAmmo - ammo);
        ammo += ammoFilling;
        return ammoFilling;
    }

    public String getType(){
        return this.type;
    }

    public int getAmmoStore(){
        return ammo;
    }

    public void getStatus(){
        System.out.println("Type " +  type + ", " + "Ammo: " + ammo + ", " + "Base Damage: " + baseDemage + ", "+ "All Damage: " + demage + ".");
    }

    public boolean isEmpty() {
        if (ammo == 0) {
            isEmpty = true;
        } else {
            isEmpty = false;
        }
        return isEmpty;
    }

}
