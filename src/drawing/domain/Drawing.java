package drawing.domain;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Vai on 2/14/17.
 */
@SuppressWarnings("ALL")
public class Drawing implements Serializable {

    public Drawing(String name, ArrayList<DrawingItem> items) {
        this.name = name;
        this.items = items;
    }

    public Drawing() {
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

    private ArrayList<DrawingItem> items = new ArrayList<>();

    public ArrayList<DrawingItem> getItems() {
        return items;
    }

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



    public void setItems(ArrayList<DrawingItem> items) {
        this.items = items;
    }

}
