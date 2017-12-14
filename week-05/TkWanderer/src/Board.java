import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;


public class Board extends JPanel implements ActionListener {

    private Timer timer;
    private Hero hero;
    private Monster monster1;
    private Monster monster2;
    private Monster monster3;
    private BossMonster bossMonster;
    Background floor;
    Background wall;
    private final int DELAY = 100;

    public Board() {
        initBoard();
        add(new ScoreDisplay());
    }

    private void initBoard() {

        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.WHITE);

        hero = new Hero();
        monster1 = new Monster(4,4);
        monster2 = new Monster(0,9);
        monster3 = new Monster(9,0);
        floor = new Floor();
        wall = new Wall();
        bossMonster = new BossMonster();

        timer = new Timer(DELAY, this);
        timer.start();
    }

    public Hero getHero() {
        return hero;
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        doDrawing(g);

        Toolkit.getDefaultToolkit().sync();
    }

    private void doDrawing(Graphics g) {
        floor.drawBackground(g);
        wall.drawBackground(g);
        monster1.drawCharacter(g);
        monster2.drawCharacter(g);
        monster3.drawCharacter(g);
        bossMonster.drawCharacter(g);
        hero.drawCharacter(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        hero.move();
        repaint();
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            hero.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            hero.keyPressed(e);
        }
    }


}
