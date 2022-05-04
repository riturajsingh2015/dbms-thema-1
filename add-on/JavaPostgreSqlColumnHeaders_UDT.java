import java.sql.*;
import java.util.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JavaPostgreSqlColumnHeaders_UDT {

    public static void main(String[] args) {

        String username ="postgres"; // give your username here
        String password ="postgresql_786"; // give the postgreSQL password
        // CREATE Jdbcurl STRING TO CONNECT TO TEST DB WHICH IS ALREADY CREATED ON THE POSTGRESQL SERVER
        String jdbcURL = "jdbc:postgresql://localhost:5432/test";
        String query = "SELECT * FROM location";

        try (Connection con = DriverManager.getConnection(jdbcURL, username, password);
             PreparedStatement pst = con.prepareStatement(query);
             ResultSet rs = pst.executeQuery()) {

            ResultSetMetaData meta = rs.getMetaData();
            // columns information mithilfe von metaData()
            String colname1 = meta.getColumnName(1);
            String colname2 = meta.getColumnName(2);

            Formatter fmt1 = new Formatter();
            fmt1.format("%-21s%s", colname1, colname2);
            System.out.println(fmt1);
            System.out.println("-----------------------------------");
            while (rs.next()) {
                Formatter fmt2 = new Formatter();
                fmt2.format("%-21s", rs.getString(1));
                System.out.print(fmt2);
                System.out.println(rs.getObject(2).toString());
            }

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(
                    JavaPostgreSqlColumnHeaders_UDT.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }
}