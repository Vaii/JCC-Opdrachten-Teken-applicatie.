package drawing.domain;

import com.mysql.jdbc.PreparedStatement;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.xml.transform.Result;
import java.io.*;
import java.sql.*;
import java.util.Properties;


/**
 * Created by Vai on 3/7/17.
 */
public class DatabaseMediator implements PersistencyMediator {
    Properties props;

    Connection Con = null;



    public void closeConnection(){
        throw new NotImplementedException();
    }

    public void initConnection() throws SQLException {

        Con = DriverManager.getConnection(
                "jdbc:mysql://studmysql01.fhict.local/dbi354549", "dbi354549", "bamihap");

    }

    @Override
    public Drawing load(String nameDrawing) throws SQLException, IOException, ClassNotFoundException {
        initConnection();
        Statement myStatement = Con.createStatement();
        ResultSet myRs = null;
        String sql = "SELECT drawingInfo FROM drawing WHERE ID = 5";

        myRs = myStatement.executeQuery(sql);
        byte[] drawingAsBytes;

        if (myRs.next()){
            drawingAsBytes = (byte[])myRs.getObject(1);
            ByteArrayInputStream baip = new ByteArrayInputStream(drawingAsBytes);
            ObjectInputStream ois = new ObjectInputStream(baip);
            Drawing drawing = (Drawing)ois.readObject();
            return drawing;
        }


        return null;

    }

    @Override
    public boolean save(Drawing drawing) throws SQLException, IOException {

        java.sql.PreparedStatement myStatement = null;
        initConnection();
        String sql = "INSERT INTO drawing (DrawingInfo) VALUES (?)";
        myStatement = Con.prepareStatement(sql);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(drawing);
        byte[] drawingAsBytes = baos.toByteArray();

        ByteArrayInputStream bais = new ByteArrayInputStream(drawingAsBytes);
        myStatement.setBinaryStream(1, bais);
        myStatement.executeUpdate();

        return true;
    }

    @Override
    public boolean init(Properties props) throws SQLException, IOException {
        initConnection();

    return false;
    }
}
