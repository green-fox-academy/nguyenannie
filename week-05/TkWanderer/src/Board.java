import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;


public class Board extends JPanel implements ActionListener {

    private Timer timer;
    private GameController gc;
    private final int DELAY = 100;

    public Board() {
        initBoard();
        //add(new ScoreDisplay());
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
        for(int i = 0; i < gc.getMonsterList().size(); i ++){
            gc.getMonster(i).drawCharacter(g);
        }
        gc.getHero().drawCharacter(g);
        gc.drawInfo(g);
        //System.out.println(gc.getHero().currentHealthPoint + " " + gc.getHero().strikePoint + " " + gc.getMonster(0).currentHealthPoint);
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
