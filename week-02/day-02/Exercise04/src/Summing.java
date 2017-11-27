public class Summing {
    public static void main(String[] args) {
        int a = 12;
        System.out.print(summing(a));
    }
    private static int summing(int x) {
        int sum = 0;
        for (int i = 0; i < x + 1; i ++) {
            sum += i;
        }
        return sum;
    }
}
