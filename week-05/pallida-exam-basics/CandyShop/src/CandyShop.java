import java.util.ArrayList;
import java.util.List;

class CandyShop {
    static final Lollipop LOLLIPOP = new Lollipop(10,5);
    static final Candy CANDY = new Candy(20,10);

    private List<Sweet> storage;
    private int sugarStorage;
    private double income;

    CandyShop(int sugarStorage) {
        storage = new ArrayList<>();
        this.sugarStorage = sugarStorage;
    }

    void createSweets(Sweet sweet) {
        sugarStorage -= sweet.sugar;
        storage.add(sweet);
    }

    void sell(Sweet sweet, int pcs) {
        income += sweet.price;
        storage.remove(sweet);
    }

    void buySugar(int amount) {
        income -= amount * 0.1;
        sugarStorage += amount;
    }

    void raise(double percentage) {
        for(Sweet sweet:storage) {
            sweet.raisePrice(percentage);
        }
    }

    @Override
    public String toString( ) {
        int candies = 0;
        int lollipops = 0;
        for(Sweet sweet:storage) {
            if(sweet.type.equals("lollipop")) {
                lollipops++;
            }
            if(sweet.type.equals("candy")) {
                candies++;
            }
        }
        return "Inventory: " + candies +" candies, " + lollipops + " lollipops, Income: "
                + income + "$, Sugar: " + sugarStorage + "gr";
    }
}
