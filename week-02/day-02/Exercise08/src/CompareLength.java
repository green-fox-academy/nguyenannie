public class CompareLength {
    public static void main(String[] args) {
        int[] p1 = {1, 2, 3};
        int[] p2 = {4, 5};

        if (p1.length < p2.length){
            System.out.print(p2[0]);
        } else {
            System.out.print(p1[0]);
        }
    }
}
