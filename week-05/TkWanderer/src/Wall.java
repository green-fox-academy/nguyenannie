import java.awt.*;

public class Wall extends Background {
    private final int[] wallX = {3,5,3,5,1,2,3,5,5,0,1,2,3,5,6,7,8,1,3,8,1,3,5,6,8,5,6,8,1,2,3,8,3,5,6,8,1,3,5};
    private final int[] wallY = {0,0,1,1,2,2,2,2,3,4,4,4,4,4,4,4,4,5,5,5,6,6,6,6,6,7,7,7,8,8,8,8,9,9,9,9,10,10,10};


    public Wall(){
        fileName = "wall.gif";
        initBackground();
    }

    @Override
    public void drawBackground(Graphics g) {
        for(int i = 0; i < wallX.length; i ++){
            setCorX(wallX[i] * getBounds().width);
            setCorY(wallY[i] * getBounds().height);
            Graphics2D g2d = (Graphics2D) g;
            g2d.drawImage(getTexture(), getCorX(), getCorY(), null);
        }
    }
}
