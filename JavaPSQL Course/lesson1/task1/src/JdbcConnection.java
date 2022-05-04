import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JdbcConnection {
    // Jdbcurl STRING ERSTELLEN, UM EINE VERBINDUNG MIT DER TEST-DB ZU VERBINDEN
    String url = "jdbc:postgresql://localhost:5432/test";
    String user = "postgres";
    String password = "postgresql_786";

    public String getUrl() {
        return url;
    }

    public String getUser() {
        //This is comment
        //New Comment
        //ich habe diese Datei geandert
        return user;
    }

    public String getPassword() {
        return password;
    }

    //Erställt einen Logger mit dem Klassennamen JdbcConnection,um Ausnamen zu protokolieren
    private static final Logger LOGGER =
            Logger.getLogger(JdbcConnection.class.getName());
    private static Connection connection = null;
    /* Deklariert in der JdbcConnection-Klasse eine statische Methode getConnection ().
     Die Methode getConection () registriert den driver und stellt die Datenbankverbindung her,
      indem url, user und password übergeben werden,
      */
    public static Connection getConnection() {
        try {
            JdbcConnection jdbc = new JdbcConnection();
            connection = DriverManager.getConnection(jdbc.url, jdbc.user, jdbc.password);
        }
        //Im Falle einer Ausnahme protokollieren wir die Fehlermeldung
        catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
        return connection;
    }

}