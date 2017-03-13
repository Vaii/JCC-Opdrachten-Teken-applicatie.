package drawing.domain;

import javafx.scene.canvas.GraphicsContext;

/**
 * Created by Vai on 2/21/17.
 */
public class JavaFXPaintable implements Paintable {
    public JavaFXPaintable(GraphicsContext graphics) {
        this.graphics = graphics;
    }

    public GraphicsContext getGraphics() {
        return graphics;
    }

    public void setGraphics(GraphicsContext graphics) {
        this.graphics = graphics;
    }

    GraphicsContext graphics;

    @Override
    public void paint(Oval oval)
    {
        graphics.strokeOval(oval.getAnchor().getX(), oval.getAnchor().getY(), oval.getWidth(), oval.getHeight());
    }

    @Override
    public void paint(Polygon polygon)
    {
        double[] x = new double[polygon.getVertices().size()];
        double[] y = new double[polygon.getVertices().size()];

        int count = 0;

        for (Point point : polygon.getVertices())
        {
            x[count] = point.getX();
            y[count] = point.getY();
            count++;
        }

        graphics.strokePolygon(x, y, polygon.getVertices().size());
    }

    @Override
    public void paint(PaintedText text)
    {
        graphics.fillText(text.getContent(), text.getAnchor().getX(), text.getAnchor().getY(), text.getWidth());
    }

    @Override
    public void paint(Image image)
    {
        javafx.scene.image.Image img = new javafx.scene.image.Image(image.getFile().toURI().toString());
        graphics.drawImage(img, image.getAnchor().getX(), image.getAnchor().getY(), image.getWidth(), image.getHeight());
    }
}
