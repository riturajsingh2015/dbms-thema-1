import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JavaPostgreSqlWriteImage {

    String DROP = "DROP TABLE IF EXISTS images";
    String CREATE = "CREATE TABLE IF NOT EXISTS images(id serial, data bytea)";
    String INSERT ="INSERT INTO images(data) VALUES(?)";

    public String getDROP() {
        return DROP;
    }

    public String getCREATE() {
        return CREATE;
    }

    public String getINSERT() {
        return INSERT;
    }

    public static void main(String[] args) {
        //Verbindung mit DB

        Connection con = JdbcConnection.getConnection();
        //Erställt eine neue Instanz aus JavapostgreSQLWriteImage Klasse

        JavaPostgreSqlWriteImage img_rw = new JavaPostgreSqlWriteImage();
          /* mithilfe vorbereitete Anweisungen,verwenden wir Platzhalter,
        anstatt die Werte direkt in die Anweisungen zu schreiben.
        damit versuchen wir,Drop und Create durchzuführen
         */
        try(PreparedStatement pst = con.prepareStatement(img_rw.INSERT)) {
            Statement stmt = con.createStatement();
            stmt.executeUpdate(img_rw.DROP);
            System.out.println("Existing Table Droppped");
            stmt.executeUpdate(img_rw.CREATE);
            System.out.println("New Table Created");
            File img = new File("resources/pulp.jpg");
            //versucht,neus Bild zu DB hinzufügen
            try (FileInputStream fin = new FileInputStream(img)) {
                /*
                Die Umwandlung in (int) ist erforderlich,
                da es in JDBC 4 auch eine Version dieser Methode mit a (int, long) gibt.
                */
                pst.setBinaryStream(1, fin, (int) img.length());
                pst.executeUpdate();
                System.out.println("Image added to Database");
            }
            //Im Falle einer Ausnahme protokollieren wir die Fehlermeldung
            catch (IOException ex) {
                Logger.getLogger(JavaPostgreSqlWriteImage.class.getName()).log(
                        Level.SEVERE, ex.getMessage(), ex);
            }
        con.close();
        }
        //Im Falle einer Ausnahme protokollieren wir die Fehlermeldung
        catch (SQLException ex) {
            Logger lgr = Logger.getLogger(JavaPostgreSqlWriteImage.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }
}