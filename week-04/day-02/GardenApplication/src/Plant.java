public class Plant {
    String color;
    String atype;
    double waterStatus;
    double waterAbsorbRate;
    boolean needWater;

    public Plant(){
        waterStatus = 0;
    }

    public boolean isNeedWater() {
        return needWater;
    }


}
