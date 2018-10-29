package fibpong;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
//import javafx.util.Pair;

public class PongDB {
    public static void insertRecord(String name, int shots){
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/pongdb?useTimezone=true&serverTimezone=UTC", "ponguser", "123456");
            statement = connection.prepareStatement("INSERT INTO records (name, shots) values (?, ?)");
            statement.setString(1, name);
            statement.setInt(2, shots);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PongDB.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(PongDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public static void removeRecord(String name){
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/pongdb?useTimezone=true&serverTimezone=UTC", "ponguser", "123456");
            statement = connection.prepareStatement("DELETE FROM records WHERE name = ?");
            statement.setString(1, name);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PongDB.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(PongDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        
    }
    public static void removeAllRecords(){
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/pongdb?useTimezone=true&serverTimezone=UTC", "ponguser", "123456");
            statement = connection.prepareStatement("DELETE FROM records WHERE 1");
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PongDB.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(PongDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
//    public static ArrayList<Pair> getRecords(){
//        Connection connection = null;
//        Statement statement = null;
//        ResultSet resultSet = null;
//        ArrayList<Pair> records = new ArrayList();
//        try {
//            connection = DriverManager.getConnection("jdbc:mysql://localhost/pongdb?useTimezone=true&serverTimezone=UTC", "ponguser", "123456");
//            statement = connection.createStatement();
//            resultSet = statement.executeQuery("SELECT name, shots FROM records" );
//            while(resultSet.next()){
//                Pair p = new Pair(resultSet.getObject(1), resultSet.getObject(2));
//                records.add(p);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(PongDB.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return records;
//    }
}