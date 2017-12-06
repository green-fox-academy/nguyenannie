public class Main {
    public static void main(String[] args) {
        Sharpie sharpie = new Sharpie("green", 150);
        System.out.println(sharpie.inkAmount);
        sharpie.use(20);
        System.out.println(sharpie.inkAmount);

    }
}
