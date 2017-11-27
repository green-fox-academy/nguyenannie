public class SwapElements {
    public static void main(String[] args) {
        String[] abc = {"first", "second", "third"};

        String  c = "";
        c = abc[0];
        abc[0] = abc[2];
        abc[2] = c;

        for(int i = 0; i < abc.length; i++) {
            System.out.print(abc[i] + " ");
        }
    }
}
