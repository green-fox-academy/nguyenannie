public class Flower extends Plant{

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
        if(waterLevel < 5) {
            needWater = true;
        } else {
            needWater = false;
        }
        return needWater;
    }


}
