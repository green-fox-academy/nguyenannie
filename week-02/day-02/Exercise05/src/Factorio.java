public class Factorio {
    public static void main(String[] args) {
        int a = 12;
        System.out.println(factorio(a));

    }

    private static int factorio(int x) {
        int product = 1;
        if ( x == 0){
            return 1;
        } else {
            for (int i = 1; i < x + 1; i++) {
                product *= i;
            }
            return product;
        }
    }
}
