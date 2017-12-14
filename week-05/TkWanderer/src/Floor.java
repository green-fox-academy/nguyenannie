import java.awt.*;

public class Floor extends Background {

    static final int tileSize = 72;

    public Floor(){
        fileName = "floor.gif";
        initBackground();
    }

    public void drawBackground(Graphics g){
        for(int i = 0; i < 10 ; i ++){
            for(int j = 0; j < 11; j ++) {
                setCorX(i * getBounds().width);
                setCorY(j * getBounds().height);
                Graphics2D g2d = (Graphics2D) g;
                g2d.drawImage(getTexture(), getCorX(), getCorY(), null);
            }
        }
    }

}
