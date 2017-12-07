public class Tree extends Plant{
    String color;
    String atype;
    double waterStatus;
    double waterAbsorbRate;
    boolean needWater;

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
        if(waterStatus < 10) {
            needWater = true;
            System.out.println("Tree " + color + " needs water.");
        } else {
            needWater = false;
            System.out.println("Tree " + color + " doesnt need water.");
        }
        return needWater;
    }
}
