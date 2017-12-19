import java.awt.*;
import javax.swing.*;

public class GamePlay extends JFrame {
    public GamePlay() {

        initUI();
    }

    private void initUI() {
        add(new Board());

        setSize(10 * Tile.tileSize,11 * Tile.tileSize + 23);
        setResizable(false);

        setTitle("TKWanderer");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {

            GamePlay gamePlay = new GamePlay();
            gamePlay.setVisible(true);
        });
    }
}
