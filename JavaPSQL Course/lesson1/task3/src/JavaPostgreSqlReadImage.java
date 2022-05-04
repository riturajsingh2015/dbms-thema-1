import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class JavaPostgreSqlReadImage {
    String SELECT="SELECT data, LENGTH(data) FROM images WHERE id = 1";
    String op_file_name="resources/pulp_op.jpg";

    public String getSELECT() {
        return SELECT;
    }

    public String getOp_file_name() {
        return op_file_name;
    }

    public static void main(String[] args) {
        //Verbindung mit DB
        Connection con = JdbcConnection.getConnection();
        //Erställt eine neue Instanz aus JavapostgreSQLReadImage Klasse
        JavaPostgreSqlReadImage img_r = new JavaPostgreSqlReadImage();
        //Versucht,ein Anweisungsobjekt zum Senden von SQL-Anweisungen an DB zu erstellen
        try(PreparedStatement pst = con.prepareStatement(img_r.SELECT);
                /* executeQuery führt die angegebene SQL-Anweisung aus,
            die ein einzelnes ResultSet-Objekt zurückgibt
            und ResultSet ist eine Datentabelle,
            die von einer bestimmten SQL-Anweisung zurückgegeben wird.
             */

            ResultSet rs = pst.executeQuery()) {
      /* ResultSet-Objekt behält einen Cursor bei, der auf seine aktuelle Datenzeile zeigt
            Zunächst befindet sich der Cursor vor der ersten Zeile
            Die next ()-Methode bewegt den Cursor in die nächste Zeile
             */
            rs.next();
            File myFile = new File(img_r.op_file_name);
            //Erställt einen Dateiausgabe stream zum Schreiben in ein Dateiobjekt
            try (FileOutputStream fos = new FileOutputStream(myFile)) {
                int len = rs.getInt(2);
                byte[] buf = rs.getBytes("data");
                fos.write(buf, 0, len);
                //schreiben Sie Java-Code, um ein Bild
                // auf dem Bildschirm anzuzeigen

                JFrame frame = new JFrame();
                ImageIcon icon = new ImageIcon(img_r.op_file_name);
                JLabel label = new JLabel(icon);
                frame.add(label);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
                //jetzt machen wir die Verbindnung zu
                con.close();
            }
        }    // Im Falle einer Ausnahme protokollieren wir die Fehlermeldung
        catch (IOException | SQLException ex) {

            Logger lgr = Logger.getLogger(JavaPostgreSqlReadImage.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }



    }
}