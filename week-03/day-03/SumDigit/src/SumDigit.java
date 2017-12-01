public class SumDigit {
    public static void main(String[] args) {
        System.out.print(sumdigit(1234));
    }
    public static int sumdigit(int n) {
        if(n / 10 < 1) {
            return n;
        } else {
            return sumdigit(n /10) + n % 10;
        }
    }
}
