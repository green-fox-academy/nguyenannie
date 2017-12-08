public class Main {
    public static void main(String[] args) {
        Carrier carrier = new Carrier();

        carrier.addAircraft("F35");
        carrier.addAircraft("F16");


        for(int i = 0; i < carrier.airCrafts.size(); i++){
            carrier.airCrafts.get(i).getStatus();
        }

    }
}
