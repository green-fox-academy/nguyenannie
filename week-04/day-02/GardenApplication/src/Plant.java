public class Plant {
    String color;
    String atype;
    double waterLevel;
    double waterAbsorbRate;
    boolean needWater;

    public Plant(){
        waterLevel = 0;
    }

    public boolean isNeedWater() {
        return needWater;
    }


}
