package drawing.domain;

import java.io.*;
import java.util.Properties;

/**
 * Created by Vai on 3/7/17.
 */
public class SerializationMediator implements PersistencyMediator {
    Properties props;





    public SerializationMediator() throws IOException {
    }

    @Override
    public Drawing load(String nameDrawing) throws IOException, ClassNotFoundException {
        FileInputStream input = new FileInputStream("/Users/user/Documents/JCC Opslag/" + nameDrawing);
        ObjectInputStream inputStream = new ObjectInputStream(input);
        return (Drawing) inputStream.readObject();
    }

    @Override
    public boolean save(Drawing drawing) throws IOException {
        FileOutputStream output = new FileOutputStream("/Users/user/Documents/JCC Opslag/DO.ser");
        ObjectOutputStream outputStream = new ObjectOutputStream(output);
        outputStream.writeObject(drawing);
        return true;
    }

    @Override
    public boolean init(Properties props) {
        return false;
    }
}
