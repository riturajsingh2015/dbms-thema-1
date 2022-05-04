import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao{
    @Override
    public boolean insertUser(User user) {
        //Datenbankverbindungsbefehl
        Connection connection = JdbcConnection.getConnection();
        try {
            //Die vorbereitete Anweisung verwendet die INSERT-Abfrage, um die Benutzerdetails in die Tabelle einzufügen
            PreparedStatement ps = connection.prepareStatement("INSERT INTO users VALUES (?, ?, ?, ?)");
            ps.setInt(1, user.getId());
            ps.setString(2, user.getName());
            ps.setString(3, user.getPass());
            ps.setInt(4, user.getAge());
            int i = ps.executeUpdate();
//Die Methode executeUpdate gibt die Anzahl der betroffenen Zeilen zurück,
// wir erwarten, dass eine einzelne Zeile eingefügt wird, d. h. es sollte 1
// zurückgegeben werden, wenn ja, geben wir true zurück, andernfalls geben wir false zurück
            if(i == 1)
                return true;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
