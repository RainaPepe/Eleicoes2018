package fibpong;
import java.util.ArrayList;
//import javafx.util.Pair;

public class FIBPong {
    public static void main(String[] args) {
        //PongDB.removeAllRecords();
        /*PongDB.insertRecord("Giovane",16);
        PongDB.insertRecord("Edileusa",18);
        PongDB.insertRecord("Tecnico",14);*/
        /*ArrayList<Pair> records = PongDB.getRecords();
        for (Pair p : records)
            System.out.println(p);*/
        new GameFrame();
    }
}