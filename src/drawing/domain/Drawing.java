package drawing.domain;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Vai on 2/14/17.
 */
@SuppressWarnings("ALL")
public class Drawing extends DrawingItem implements Serializable {

    private ObservableList<DrawingItem> observableList;

    public ObservableList<DrawingItem> itemsToObserve(){
        return FXCollections.unmodifiableObservableList(observableList);
    }

    private List<DrawingItem> items;

    public List<DrawingItem> getItems(){
        return Collections.unmodifiableList(items);
    }

    public Drawing(String name, ArrayList<DrawingItem> items) {
        this.name = name;
        this.items = items;
    }

    public Drawing() {
        items = new ArrayList<>();
        observableList = FXCollections.observableList(items);
    }

    @Override
    public void PaintUsing(Paintable paintable) {

    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double width;
    public double height;

    @Override
    public Point getAnchor() {
        return null;
    }

    @Override
    public double getWidth() {
        return 0;
    }

    @Override
    public double getHeight() {
        return 0;
    }

    public void paintUsing(Paintable paint)
    {
        for(DrawingItem x : items)
        {
            x.PaintUsing(paint);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public void addItem(DrawingItem item)
    {

        items.add(item);
    }

    public void removeItem(DrawingItem item)
    {
        items.remove(item);
    }

    public void alterItem(DrawingItem oldItem, DrawingItem newItem)
    {
        items.remove(oldItem);
        items.add(newItem);
    }



    public void setItems(ObservableList<DrawingItem> items) {
        this.observableList = items;
    }

}
