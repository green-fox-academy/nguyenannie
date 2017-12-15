import java.awt.*;
import javax.swing.*;

public class GamePlay extends JFrame {
    Board board = new Board();

    public GamePlay() {

        initUI();
    }

    private void initUI() {
        add(board, BorderLayout.CENTER);

        setSize(10 * Tile.tileSize,11 * Tile.tileSize + 23);
        setResizable(false);

        setTitle("Game Plays");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        Board board = new Board();

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                GamePlay ex = new GamePlay();
                ex.setVisible(true);
            }
        });
    }
}
