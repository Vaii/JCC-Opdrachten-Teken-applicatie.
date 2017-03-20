import drawing.domain.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javafx.scene.canvas.Canvas;

import java.awt.event.ActionEvent;
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

        primaryStage.setTitle("JCC Opdracht");
        Parent root = FXMLLoader.load(getClass().getResource("stomding.fxml"));

        primaryStage.setScene(new Scene(root));
        primaryStage.show();


//        serializationMediator.save(drawing);

    }
}
