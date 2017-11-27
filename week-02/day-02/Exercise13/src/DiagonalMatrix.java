public class DiagonalMatrix {
    public static void main(String[] args) {
        int[][] k = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j ++) {
                if (j == i) {
                    k[i][j] = 1;
                } else {
                    k[i][j] = 0;
                }
                System.out.print(k[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}
