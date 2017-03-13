package drawing.domain;

import java.io.Serializable;

/**
 * Created by Vai on 2/14/17.
 */
@SuppressWarnings("ALL")
public class Oval extends DrawingItem implements Serializable{

    private Point anchor;

    public Oval(Point anchor, double width, double height, double weight) {
        this.anchor = anchor;
        this.width = width;
        this.height = height;
        this.weight = weight;
    }

    public Oval() {
    }

    @Override
    public void PaintUsing(Paintable paintable) {
        paintable.paint(this);

    }

    public Point getAnchor() {
        return anchor;
    }

    public void setAnchor(Point anchor) {
        this.anchor = anchor;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    private double width;

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    private double height;

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    private double weight;

    @Override
    public String toString() {
        return "Oval{" +
                "anchor=" + anchor +
                ", width=" + width +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }
}
