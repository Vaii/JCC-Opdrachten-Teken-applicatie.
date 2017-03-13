import drawing.domain.*;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javafx.scene.canvas.Canvas;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


/**
 * Created by Vai on 2/21/17.
 */
public class DrawingTool extends javafx.application.Application {

    public DrawingTool() throws IOException {};

    public DrawingTool(JavaFXPaintable paintable, Drawing drawing) throws IOException {
        this.paintable = paintable;
        this.drawing = drawing;
    }

    public SerializationMediator getSerializationMediator() {
        return serializationMediator;
    }

    public void setSerializationMediator(SerializationMediator serializationMediator) {
        this.serializationMediator = serializationMediator;
    }

    public DatabaseMediator getDatabaseMediator() {
        return databaseMediator;
    }

    public void setDatabaseMediator(DatabaseMediator databaseMediator) {
        this.databaseMediator = databaseMediator;
    }

    private SerializationMediator serializationMediator = new SerializationMediator();
    private DatabaseMediator databaseMediator = new DatabaseMediator();

    public JavaFXPaintable getPaintable() {
        return paintable;
    }

    private void setPaintable(JavaFXPaintable paintable) {
        this.paintable = paintable;
    }

    private JavaFXPaintable paintable;

    private Drawing drawing;

    private void draw()
    {
        drawing.paintUsing(paintable);
    }

    public Drawing getDrawing() {
        return drawing;
    }

    public void setDrawing(Drawing drawing) {
        this.drawing = drawing;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        primaryStage.setTitle("JCC Opdracht week 2");
        Group root = new Group();

        Canvas canvas = new Canvas(700,500);

        Drawing drawing = (databaseMediator.load("test"));
//        Drawing drawing = new Drawing();
//        drawing.addItem(new Oval(new Point(20.0, 15.0), 50.0, 50.0, 40.0));
//
//        ArrayList<Point> porygonList = new ArrayList<>();
//        porygonList.add(new Point(100.0, 100.0));
//        porygonList.add(new Point(50.0, 20.0));
//        porygonList.add(new Point(10.0, 90.0));
//
//        drawing.addItem(new Polygon(porygonList));
//
//        drawing.addItem(new Image(new File("/Users/user/Desktop/iishost.png"), new Point(100.0, 200.0), 300, 300));
//
//        drawing.addItem(new PaintedText("JavaTekenen", "Comic Sans", new Point(150.0, 100.0), 50, 100));

        this.setPaintable(new JavaFXPaintable(canvas.getGraphicsContext2D()));
        this.setDrawing(drawing);

        drawing.addItem(new Oval(new Point(40.0, 25.0), 45.0, 55.0, 65.0));

        draw();



        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

//        serializationMediator.save(drawing);

    }
}
