package View;

import Controller.GameController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class Board extends JPanel implements ActionListener {
    private GameController controller;
    private DisplayStat displayStat;
    private DisplayChacters displayChacters;
    private DisplayMaze displayMaze;
    private final int DELAY = 100;

    public Board() {
        initBoard();
    }

    private void initBoard() {
        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.WHITE);

        controller = new GameController();
        displayStat = new DisplayStat();
        displayMaze = new DisplayMaze();
        displayChacters = new DisplayChacters();

        Timer timer = new Timer(DELAY, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawGame(g);
    }

    private void drawGame(Graphics g) {
        displayMaze.draw(g);
        for(int i = 0; i < controller.getMonsterList().size(); i++) {
            displayChacters.draw(controller.getMonster(i), g);
        }
        displayChacters.draw(controller.getHero(), g);
        displayStat.draw(g);
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
