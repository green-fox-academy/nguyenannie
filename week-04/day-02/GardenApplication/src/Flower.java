public class Flower extends Plant{
    String color;
    String atype;
    double waterStatus;
    double waterAbsorbRate;
    boolean needWater;

    public Flower() {
        waterAbsorbRate = 0.75;
        atype = "Flower";
    }

    public void setColor(String color) {
        this.color = color;
    }
    public String getColor(){
        return this.color;
    }

    public boolean isNeedWater() {
        if(waterStatus < 5) {
            needWater = true;
            System.out.println("Flower " + color + " needs water.");
        } else {
            needWater = false;
            System.out.println("Tree " + color + " doesnt need water.");
        }
        return needWater;
    }


}
