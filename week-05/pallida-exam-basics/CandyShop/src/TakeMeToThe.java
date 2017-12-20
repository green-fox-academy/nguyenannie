public class TakeMeToThe {
    public static void main(String[] args) {
        CandyShop candyShop = new CandyShop(300);
        candyShop.createSweets(CandyShop.CANDY);
        candyShop.createSweets(CandyShop.CANDY);
        candyShop.createSweets(CandyShop.LOLLIPOP);
        candyShop.createSweets(CandyShop.LOLLIPOP);
        System.out.println(candyShop);
        // Should print out:
        // Inventory: 2 candies, 2 lollipops, Income: 0$, Sugar: 270gr
        candyShop.sell(CandyShop.CANDY, 1);
        System.out.println(candyShop);
        // Should print out:
        // "Inventory: 1 candies, 2 lollipops, Income: 20$, Sugar: 270gr"
        candyShop.raise(5);
        candyShop.sell(CandyShop.LOLLIPOP, 1);
        System.out.println(candyShop);
        // Should print out:
        // "Inventory: 1 candies, 1 lollipops, Income: 30.5$, Sugar: 270gr"
        candyShop.buySugar(300);
        System.out.println(candyShop);
        // Should print out:
        // "Inventory: 1 candies, 1 lollipops, Income: 5$, Sugar: 570gr"
    }
}
