//don't use this one

import java.awt.*;

public class Turtle {
    public Turtle(){

    }
    Graphics g;
    private double x, y;     // turtle is at (x, y)
    private double angle;    // facing this many degrees counterclockwise from the x-axis

    // start at (x0, y0), facing a0 degrees counterclockwise from the x-axis
    public Turtle(double x0, double y0, double a0) {
        x = x0;
        y = y0;
        angle = a0;
    }

    // rotate orientation delta degrees counterclockwise
    public void turn(double delta) {
        angle += delta;
    }

    // move forward the given amount, with the pen down
    public void goForward(double length) {
        double oldx = x;
        double oldy = y;
        x += length * Math.cos(angle);
        y += length * Math.sin(angle);
        g.drawLine((int)oldx, (int)oldy, (int)x, (int)y);
    }
}
