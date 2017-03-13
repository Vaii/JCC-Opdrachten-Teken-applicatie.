package drawing.domain;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by Vai on 3/7/17.
 */
public interface PersistencyMediator {

    Drawing load(String nameDrawing) throws IOException, ClassNotFoundException, SQLException;
    boolean save(Drawing drawing) throws IOException, SQLException;
    boolean init(Properties props) throws SQLException, IOException;
}
