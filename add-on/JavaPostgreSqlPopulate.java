import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.ibatis.jdbc.ScriptRunner;

public class JavaPostgreSqlPopulate {
    public static void main(String[] args) {
        // TODO Auto-generated method stub


        String username ="postgres"; // give your username here
        String password ="postgresql_786"; // give the postgreSQL password
        // CREATE Jdbcurl STRING TO CONNECT TO TEST DB WHICH IS ALREADY CREATED ON THE POSTGRESQL SERVER
        String jdbcURL = "jdbc:postgresql://localhost:5432/test";
        try {
            //TRY TO CONNECT BY MAKING A JDBC CONNECTION
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            System.out.println("Connected to test DB");
            //Initialize the script runner
            ScriptRunner sr = new ScriptRunner(connection);
            //Creating a reader object
            Reader reader = null;
            try {
                reader = new BufferedReader(new FileReader("src/main/resources/authors_books_postgresql.sql"));
                //Running the script
                sr.runScript(reader);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            connection.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            // ERROR HANDLING CODE GOES HERE
            System.out.println("Connection unsuccessful");
            e.printStackTrace();
        }

    }


}
