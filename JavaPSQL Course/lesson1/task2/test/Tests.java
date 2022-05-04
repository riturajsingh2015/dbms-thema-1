import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Tests {
  JavaPostgreSqlWriteImage img_rw= new JavaPostgreSqlWriteImage();
  @Test
  public void testSolution() {
    // put your test here

    assertEquals("DROP query incorrect","DROP TABLE IF EXISTS images", img_rw.getDROP());
    assertEquals("CREATE query incorrect","CREATE TABLE IF NOT EXISTS images(id serial, data bytea)", img_rw.getCREATE());
    assertEquals("INSERT query incorrect","INSERT INTO images(data) VALUES(?)", img_rw.getINSERT());

  }
}