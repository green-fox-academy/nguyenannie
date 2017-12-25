import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;

class Board extends JPanel implements ActionListener {
    private GameController controller;
    private Display display;
    private final int DELAY = 100;

    Board() {
        initBoard();
    }

    private void initBoard() {
        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.WHITE);

        controller = new GameController();
        display = new Display();

        Timer timer = new Timer(DELAY, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawGame(g);
    }

    private void drawGame(Graphics g) {
        controller.getMaze().draw(g);
        for(int i = 0; i < controller.getMonsterList().size(); i++) {
            controller.getMonster(i).draw(g);
        }
        controller.getHero().draw(g);
        display.displayStat(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    private class TAdapter extends KeyAdapter {
        @Override
        public void keyReleased(KeyEvent e) {
            controller.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            controller.keyPressed(e);

        }
    }
}
