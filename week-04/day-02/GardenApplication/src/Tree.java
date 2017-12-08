public class Tree extends Plant{

    public Tree(){
        waterAbsorbRate = 0.4;
        atype = "Tree";
    }

    public void setColor(String color) {
        this.color = color;
    }
    public String getColor(){
        return this.color;
    }

    public boolean isNeedWater() {
        if(waterLevel < 10) {
            needWater = true;
        } else {
            needWater = false;
        }
        return needWater;
    }
}
