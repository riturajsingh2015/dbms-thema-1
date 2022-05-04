import org.junit.Test;
import static org.junit.Assert.*;

public class Jdbc_test {
  JdbcConnection jdbc= new JdbcConnection();
  @Test
  public void testSolution() {

    assertEquals("username should be","postgres", jdbc.getUser());
    assertEquals("passoword should be","postgresql_786", jdbc.getPassword());
    assertEquals("jdbc_URL should be","jdbc:postgresql://localhost:5432/test", jdbc.getUrl());
    assertEquals("connection is not established",true, !JdbcConnection.getConnection().equals(null));
   }
}
