import javax.swing.*;
import java.awt.*;

public class Background {
    protected int corX;
    protected int corY;
    protected Image texture;
    protected String fileName;

    public Background(){
        initBackground();
    }

    public int getCorX() {
        return corX;
    }

    public void setCorX(int corX) {
        this.corX = corX;
    }

    public int getCorY() {
        return corY;
    }

    public void setCorY(int corY) {
        this.corY = corY;
    }

    public void setTexture(String fileName) {
        ImageIcon icon = new ImageIcon(fileName);
        this.texture = icon.getImage();
    }

    public Image getTexture() {
        return texture;
    }

    public void initBackground(){
        setTexture(fileName);
        corX = 0;
        corY = 0;
    }

    public Rectangle getBounds(){
        return new Rectangle(getCorX(),getCorY(),getTexture().getWidth(null),getTexture().getHeight(null));
    }

    public boolean inBound(){
        boolean result = true;
        if(this.getBounds().intersectsLine(0,0,600,0)){
            result = false;
        }
        return result;
    }

    public void drawBackground(Graphics g) {
    }


}
