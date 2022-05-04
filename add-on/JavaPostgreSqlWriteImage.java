import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JavaPostgreSqlWriteImage {

    public static void main(String[] args) {

        String username ="postgres"; // give your username here
        String password ="postgresql_786"; // give the postgreSQL password
        // CREATE Jdbcurl STRING TO CONNECT TO TEST DB WHICH IS ALREADY CREATED ON THE POSTGRESQL SERVER
        String jdbcURL = "jdbc:postgresql://localhost:5432/test";

        String query = "INSERT INTO images(data) VALUES(?)";

        try (Connection con = DriverManager.getConnection(jdbcURL, username, password);
             PreparedStatement pst = con.prepareStatement(query)) {

            File img = new File("src/main/resources/images/input/pulp.jpg");

            try (FileInputStream fin = new FileInputStream(img)) {

                pst.setBinaryStream(1, fin, (int) img.length());
                pst.executeUpdate();
            } catch (IOException ex) {
                Logger.getLogger(JavaPostgreSqlWriteImage.class.getName()).log(
                        Level.SEVERE, ex.getMessage(), ex);
            }

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(JavaPostgreSqlWriteImage.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }
}