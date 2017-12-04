import java.awt.*;

public class Turtle {
    double x,y;
    double dir = - Math.PI/2;
    Graphics g;
    boolean penState;

    Turtle(Graphics g, double x, double y) {
        this.g = g;
        this.x = x;
        this.y = y;
        this.penState = true;
    }

    public void moveForward(double step) {
        double oldX = x;
        double oldY = y;
        x += Math.cos(dir) * step;
        y += Math.sin(dir) * step;
        if(penState) {
            g.drawLine((int) oldX, (int) oldY, (int) x, (int) y);
        }
    }

    public void turn(double angle) {
        dir += angle;
    }

    public void penUp() {
        penState = false;
    }

    public void penDown() {
        penState = true;
    }
}
