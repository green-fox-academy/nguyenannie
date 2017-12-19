import javax.swing.*;
import java.awt.*;

public class Tile {
    static final int tileSize = 72;

    protected Image texture;
    protected boolean isSolid;

    Tile(String filePath, boolean isSolid) {
        this.isSolid = isSolid;
        setTexture(filePath);
    }

    void setTexture(String fileName) {
        ImageIcon icon = new ImageIcon(fileName);
        this.texture = icon.getImage();
    }

    Image getTexture() {
        return texture;
    }
}
