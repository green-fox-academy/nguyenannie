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

    private Thread thread;
    private boolean running = false;

    public Board() {
        initBoard();
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
        gc.doDrawing(g);
        Toolkit.getDefaultToolkit().sync();
    }

    public synchronized void start() {
        if(running) {
            return;
        }

        running = true;
        thread = new Thread();
        thread.start();
    }

    public void run(){
        System.out.println("hello");
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
