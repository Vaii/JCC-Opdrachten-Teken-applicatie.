package drawing.domain;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.control.Button;

import java.awt.*;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by Vai on 2/21/17.
 */
public class Controller implements Initializable {



    public Drawing drawing;
    private GraphicsContext gc;
    private JavaFXPaintable paintable;
    @FXML
    Canvas drawingCanvas;
    @FXML
    Button plsButton;
    @FXML
    ComboBox cbType;
    @FXML
    ListView items;
    @FXML
    Button btnRemove;
    @FXML
    ListView listView;

    private void draw()
    {
        gc.clearRect(0,0, drawingCanvas.getWidth(), drawingCanvas.getHeight());
        drawing.paintUsing(paintable);
        listView.setItems(drawing.itemsToObserve());
    }


    private void drawItem(ActionEvent event){


        if(cbType.getSelectionModel().getSelectedItem().toString() == "Cirkel"){
            drawing.addItem(new Oval(new Point(100, 100), 50,50,30));
        }
        
        if(cbType.getSelectionModel().getSelectedItem().toString() == "Polygon"){
            ArrayList<Point> porygonList = new ArrayList<>();

            porygonList.add(new Point(100.0, 100.0));
            porygonList.add(new Point(50.0, 20.0));
            porygonList.add(new Point(10.0, 90.0));

            drawing.addItem(new Polygon(porygonList));
        }

        if(cbType.getSelectionModel().getSelectedItem().toString() == "Text"){

            drawing.addItem(new PaintedText("JavaTekenen", "Comic Sans", new Point(150.0, 100.0), 50, 100));
        }

        if(cbType.getSelectionModel().getSelectedItem().toString() == "Image"){

            drawing.addItem(new Image(new File("/Users/user/Desktop/iishost.png"), new Point(100.0, 200.0), 300, 300));
        }

        draw();

    }

    private void removeItem(ActionEvent event){

        DrawingItem itemToRemove = (DrawingItem)listView.getSelectionModel().getSelectedItem();
        drawing.removeItem(itemToRemove);
        draw();
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        gc = drawingCanvas.getGraphicsContext2D();
        paintable = new JavaFXPaintable(gc);
        drawing = new Drawing();
        cbType.getItems().addAll("Cirkel", "Polygon", "Text", "Image");
        cbType.getSelectionModel().selectFirst();
        plsButton.setOnAction(this::drawItem);
        btnRemove.setOnAction(this::removeItem);









    }
}
