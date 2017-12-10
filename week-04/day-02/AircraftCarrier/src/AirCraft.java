public class AirCraft {
    private int ammo;
    protected int maxAmmo;
    protected int baseDamage;
    protected String type;
    private boolean isEmpty;
    private int allDamage = 0;

    public AirCraft() {
        ammo = 0;
    }

    public int fight(){
        int damage = baseDamage * ammo;
        ammo = 0;
        allDamage += damage;
        return damage;
    }

    public int refill(int ammoFilling){
        ammoFilling -= (maxAmmo - ammo);
        ammo = maxAmmo;
        return ammoFilling;
    }

    public String getType(){
        return this.type;
    }

    public int getAmmoStore(){
        return ammo;
    }

    public int getAmmoNeeded() { return maxAmmo - ammo; }

    public void getStatus(){
        System.out.println("Type " +  type +
                ", Ammo: " + ammo +
                ", Base Damage: " + baseDamage +
                ", All Damage: " + allDamage + ".");
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
