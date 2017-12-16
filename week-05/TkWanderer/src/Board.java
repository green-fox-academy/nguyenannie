import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;


public class Board extends JPanel implements ActionListener {

    private Timer timer;
    GameController gc;
    private final int DELAY = 100;

    public Board() {
        initBoard();
        add(new ScoreDisplay());
    }

    private void initBoard() {

        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.WHITE);

        gc = new GameController();

        timer = new Timer(DELAY, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        doDrawing(g);

        Toolkit.getDefaultToolkit().sync();
    }

    private void doDrawing(Graphics g) {
        gc.getMap().drawBackground(g);
        gc.getMonster(0).drawCharacter(g);
        gc.getMonster(1).drawCharacter(g);
        gc.getMonster(2).drawCharacter(g);
        gc.getMonster(3).drawCharacter(g);
        gc.getHero().drawCharacter(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            gc.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            gc.keyPressed(e);

        }
    }


}
