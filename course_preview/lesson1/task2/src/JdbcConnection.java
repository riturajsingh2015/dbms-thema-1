import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JdbcConnection {
    String url = "jdbc:postgresql://localhost:5432/test";
    String user = "postgres";
    String password = "postgresql_786";

    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    private static final Logger LOGGER =
            Logger.getLogger(JdbcConnection.class.getName());
    private static Connection connection = null;

    public static Connection getConnection() {
            try {
                JdbcConnection jdbc = new JdbcConnection();
                connection = DriverManager.getConnection(jdbc.url, jdbc.user, jdbc.password);
            } catch (SQLException ex) {
                LOGGER.log(Level.SEVERE, null, ex);
            }
        return connection;
    }

}