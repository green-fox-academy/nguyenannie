import javax.swing.*;
import java.awt.*;

class Tile {
    static final int tileSize = 72;

    private Image tileType;
    boolean isSolid;

    Tile(String filePath, boolean isSolid) {
        this.isSolid = isSolid;
        setTileType(filePath);
    }

    private void setTileType(String fileName) {
        ImageIcon icon = new ImageIcon(fileName);
        this.tileType = icon.getImage();
    }

    Image getTileType() {
        return tileType;
    }
}
