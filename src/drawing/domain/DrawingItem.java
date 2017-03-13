package drawing.domain;


import java.io.Serializable;

/**
 * Created by Vai on 2/14/17.
 */
@SuppressWarnings("ALL")
public abstract class DrawingItem implements Serializable{

    public DrawingItem(DrawingItem previousState, Color color) {
        this.previousState = previousState;
        this.color = color;
    }

    public DrawingItem() {
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public DrawingItem getPreviousState() {
        return previousState;
    }

    public abstract void PaintUsing(Paintable paintable);

    private DrawingItem previousState;

    private Color color;

    public abstract Point getAnchor();

    public abstract double getWidth();

    public abstract double getHeight();

}
