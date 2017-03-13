package drawing.domain;

/**
 * Created by Vai on 2/21/17.
 */
public interface Paintable {
    void paint(Oval oval);
    void paint(Polygon polygon);
    void paint(PaintedText text);
    void paint(Image image);
}
