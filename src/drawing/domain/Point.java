package drawing.domain;

import java.io.Serializable;

/**
 * Created by Vai on 2/14/17.
 */
@SuppressWarnings("ALL")
public class Point implements Serializable {

    private double x;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    private double y;

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
