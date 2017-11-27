public class VariableMutation {
    public static void main(String[] args) {
        int a = 3;
        a = a + 3;
        System.out.println(a);

        int b = 100;
        b = b - 7;
        System.out.println(b);

        int c = 44;
        c = c * 2;
        System.out.println(c);

        int d = 125;
        d = d / 5;
        System.out.println(d);

        int e = 8;
        e = e * e* e;
        System.out.println(e);

        int f1 = 123;
        int f2 = 345;
        System.out.println(f1 > f2);

        int g1 = 350;
        int g2 = 200;
        System.out.println(g2 > g1);

        int h = 135798745;
        System.out.println(h % 11 == 0);

        int i1 = 10;
        int i2 = 3;
        System.out.println(i1 > i2*i2 && i1 < i2*i2*i2);

        int j = 1521;
        System.out.println(j % 3 == 0 || j % 5 == 0);
        // tell if j is dividable by 3 or 5 (print as a boolean)

        String k = "Apple";
        //fill the k variable with its cotnent 4 times
        k = k + k + k + k;
        System.out.println(k);
    }
}
