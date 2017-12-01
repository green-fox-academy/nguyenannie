public class NumberAdder {
    public static void main(String[] args) {
        System.out.print(adder(5));
    }

    public static int adder(int n){
        if(n == 0) {
            return 0;
        } else {
            return adder(n - 1) + n;
        }
    }
}
