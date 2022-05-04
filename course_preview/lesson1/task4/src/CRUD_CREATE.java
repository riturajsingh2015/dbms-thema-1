import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CRUD_CREATE {
   String DROP = "Write query to drop users table";
   String CREATE = "Write query to create users table";


   public static void main(String[] args) {
      //Datenbankverbindungsbefehl
      Connection con = JdbcConnection.getConnection();
      CRUD_CREATE CRUD_ex = new CRUD_CREATE();
      try {
         //Erstellen Sie eine Anweisung zum Ausführen
         // von DROP- und CREATE-Datenbankabfragen
         Statement stmt = con.createStatement();
         //Führen Sie DROP- und CREATE-Abfragen aus
         stmt.executeUpdate(CRUD_ex.DROP);
         System.out.println("Existing Table Droppped");
         stmt.executeUpdate(CRUD_ex.CREATE);
         System.out.print("New Table Created");
         //jetzt machen wir die Verbindnung zu
         con.close();
      } //Dieser Befehl wird ausgeführt, wenn ein Fehler oder eine Ausnahme auftritt
      catch (SQLException ex) {
         Logger lgr = Logger.getLogger(CRUD_CREATE.class.getName());
         lgr.log(Level.SEVERE, ex.getMessage(), ex);
      }
   }
}