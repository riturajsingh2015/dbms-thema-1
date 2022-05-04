import java.sql.*;

public class UserDaoImpl implements UserDao{
    @Override
    public boolean insertUser(User user) {
        //Datenbankverbindungsbefehl
        Connection connection = JdbcConnection.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO users VALUES (?, ?, ?, ?)");
            ps.setInt(1, user.getId());
            ps.setString(2, user.getName());
            ps.setString(3, user.getPass());
            ps.setInt(4, user.getAge());
            int i = ps.executeUpdate();
//The executeUpdate method returns number of affected rows,
// we expect to insert a single row thus means It should return 1, if so we return true, otherwise we return false
            if(i == 1)
                return true;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public User getUser(int id) {
        //Datenbankverbindungsbefehl
        Connection connection = JdbcConnection.getConnection();
        try {
            //Auswahlabfrage erstellen,
            // um einen Benutzer mit einer bestimmten id auszuwählen
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE id=" + id);

            if(rs.next())
            {
                //Lesen Sie die Details des Users und geben Sie den User zurück
                User user = new User();
                user.setId( rs.getInt("id") );
                user.setName( rs.getString("name") );
                user.setPass( rs.getString("password") );
                user.setAge( rs.getInt("age") );
                return user;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }
}
