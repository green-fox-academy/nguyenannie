public class Colors {
    public static void main(String[] args) {
        String[][] color = new String[3][5];
        color[0][0] = "lime";
        color[0][1] = "forest green";
        color[0][2] = "olive";
        color[0][3] = "pale green";
        color[0][4] = "spring green";

        color[1][0] = "orange red";
        color[1][1] = "red";
        color[1][2] = "tomato";

        color[2][0] = "orchid";
        color[2][1] = "violet";
        color[2][2] = "pink";
        color[2][3] = "hot pink";

        for (int i = 0; i < 3; i ++) {
            for (int j = 0; j < 5; j++ ){
                System.out.print(color[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}
