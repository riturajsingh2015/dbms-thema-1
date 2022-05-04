import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;
public class JavaPostgreSqlRetrieve {

    public static void main(String[] args) {

        String username ="postgres"; // Geben Sie hier Ihren Benutzernamen ein
        String password ="postgresql_786"; //Geben Sie das postgreSQL-Passwort ein
       
        String jdbcURL = "jdbc:postgresql://localhost:5432/test";
     // Erstellen Sie eine JDBC-URL-String, um eine Verbindung zur Testdatenbank herzustellen
        try (Connection con = DriverManager.getConnection(jdbcURL, username, password);
            // Übergeben Sie die Anmeldeinformationen, um eine Verbindung herzustellen
             PreparedStatement pst = con.prepareStatement("SELECT * FROM authors");
            // Bereiten Sie eine Anweisung vor, um alle Spalten der authors-Tabelle abzurufen
           ResultSet rs = pst.executeQuery()) {
// Führen Sie die vorbereitete Anweisung aus und sammeln Sie die Ergebnisse in der ResultSet
            while (rs.next()) {
// Durchlaufen Sie jede Zeile der Ergebnismenge, um die Daten auf die Konsole / das Terminal zu drucken.
                System.out.print(rs.getInt(1));
                System.out.print(": ");
                System.out.println(rs.getString(2));
            }

        } catch (SQLException ex) {
// Dieser Block wird ausgeführt, wenn die Verbindung nicht hergestellt wurde
            Logger lgr = Logger.getLogger(JavaPostgreSqlRetrieve.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }
}
