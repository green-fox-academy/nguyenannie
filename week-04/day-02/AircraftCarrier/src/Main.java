public class Main {
    public static void main(String[] args) {
        Carrier carrier = new Carrier(100,100);

        carrier.addAircraft("F35");
        carrier.addAircraft("F16");

        //System.out.println(carrier.airCrafts.get(0).refill(300));
        //System.out.println(carrier.airCrafts.get(1).refill(300));

        for(int i = 0; i < carrier.airCrafts.size(); i++){
            carrier.airCrafts.get(i).getStatus();
        }
        System.out.println(carrier.getTotalAmmoNeeded());
        carrier.fill();
        System.out.println(carrier.getTotalDemage());

        carrier.getCarrierStatus();

    }
}
