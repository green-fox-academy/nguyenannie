import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;

class Board extends JPanel implements ActionListener {
    private GameController controller;
    private final int DELAY = 100;

    Board() {
        initBoard();
    }

    private void initBoard() {
        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.WHITE);

        controller = new GameController();

        Timer timer = new Timer(DELAY, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        draw(g);
        Toolkit.getDefaultToolkit().sync();
    }

    private void draw(Graphics g) {
        controller.getMaze().drawBackground(g);
        for(int i = 0; i < controller.getMonsterList().size(); i++) {
            controller.getMonster(i).drawCharacter(g);
        }
        controller.getHero().drawCharacter(g);
        controller.drawInfo(g);
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
