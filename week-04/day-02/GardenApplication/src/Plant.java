public class Plant {
    protected String color;
    protected String atype;
    double waterLevel;
    double waterAbsorbRate;
    boolean needWater;

    protected Plant(){
        waterLevel = 0;
    }

    public boolean isNeedWater() {
        return needWater;
    }


}
