import Model.Maze;
import Model.Tile;
import View.Board;

import java.awt.*;
import javax.swing.*;

class TKWanderer extends JFrame {
    private TKWanderer() {
        initUI();
    }

    private void initUI() {
        add(new Board());

        setSize(Maze.MAZE_WIDTH * Tile.tileSize, Maze.MAZE_HEIGHT * Tile.tileSize + 23);
        setResizable(false);

        setTitle("TKWanderer");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {

            TKWanderer wanderer = new TKWanderer();
            wanderer.setVisible(true);
        });
    }
}
