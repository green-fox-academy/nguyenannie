package View;

import Controller.GameController;
import Model.Characters;

import java.awt.*;

import static Model.Characters.step;

public class DisplayChacters extends GameController{

    public void draw(Characters characters, Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(characters.getImage(), characters.getX() * step, characters.getY() * step, null);
    }
}
