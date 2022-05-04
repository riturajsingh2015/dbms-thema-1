import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class JavaPostgreSqlReadImage{



    public static void main(String[] args) {



        String username ="postgres"; // give your username here
        String password ="postgresql_786"; // give the postgreSQL password
        // CREATE Jdbcurl STRING TO CONNECT TO TEST DB WHICH IS ALREADY CREATED ON THE POSTGRESQL SERVER
        String jdbcURL = "jdbc:postgresql://localhost:5432/test";

        String query = "SELECT data, LENGTH(data) FROM images WHERE id = 1";

        try (Connection con = DriverManager.getConnection(jdbcURL, username, password);
             PreparedStatement pst = con.prepareStatement(query);
             ResultSet rs = pst.executeQuery()) {

            rs.next();

            File myFile = new File("src/main/resources/images/output/pulp.jpg");


            try (FileOutputStream fos = new FileOutputStream(myFile)) {
                int len = rs.getInt(2);
                byte[] buf = rs.getBytes("data");
                fos.write(buf, 0, len);
            }
        } catch (IOException | SQLException ex) {

            Logger lgr = Logger.getLogger(JavaPostgreSqlReadImage.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
            System.exit(0);
        }

        JFrame frame = new JFrame();
        ImageIcon icon = new ImageIcon("src/main/resources/images/output/pulp.jpg");
        JLabel label = new JLabel(icon);
        frame.add(label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);



    }
}