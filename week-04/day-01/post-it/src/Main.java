import java.awt.Color;

public class Main {
    public static void main(String[] args) {
        PostIt postIt1 = new PostIt();
        postIt1.setBackgroundColor(Color.PINK);
        postIt1.setText("Awesome");
        postIt1.setTextColor(Color.BLACK);

        PostIt postIt2 = new PostIt();
        postIt2.setBackgroundColor(Color.ORANGE);
        postIt2.setText("Idea1");
        postIt2.setTextColor(Color.BLUE);

        PostIt postIt3 = new PostIt();
        postIt3.setBackgroundColor(Color.YELLOW);
        postIt3.setText("Superb");
        postIt3.setTextColor(Color.GREEN);


    }
}
