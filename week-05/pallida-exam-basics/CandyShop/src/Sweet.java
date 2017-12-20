abstract class Sweet {
    protected double price;
    protected int sugar;
    protected String type;

    void raisePrice(double percentage) {
        price = price * (1 + percentage/100);
    }
}
