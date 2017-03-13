package drawing.domain;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Vai on 2/14/17.
 */
@SuppressWarnings("ALL")
public class Polygon extends DrawingItem implements Serializable {

    public Polygon(ArrayList<Point> vertices, double weight) {
        this.vertices = vertices;
        this.weight = weight;
    }

    public Polygon(ArrayList<Point> vertices) {
        this.vertices = vertices;
    }

    private ArrayList<Point> vertices;

    public ArrayList<Point> getVertices() {
        return vertices;
    }

    public void setVertices(ArrayList<Point> vertices) {
        this.vertices = vertices;
    }

    private double weight;

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight(){
        throw new NotImplementedException();
    }

    public double getWidth(){
        throw new NotImplementedException();
    }

    @Override
    public void PaintUsing(Paintable paintable) {
        paintable.paint(this);

    }

    public Point getAnchor(){
        throw new NotImplementedException();
    }

    @Override
    public String toString() {
        return "Polygon{" +
                "vertices=" + vertices +
                ", weight=" + weight +
                '}';
    }
}
