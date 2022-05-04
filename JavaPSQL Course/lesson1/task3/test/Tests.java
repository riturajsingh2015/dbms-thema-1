import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
  @Test
  public void testSolution() {
    // put your test here
    JavaPostgreSqlReadImage img_r= new JavaPostgreSqlReadImage();
    assertEquals("SELECT query incorrect","SELECT data, LENGTH(data) FROM images WHERE id = 1", img_r.getSELECT());
    assertEquals("resources/pulp_op.jpg","resources/pulp_op.jpg", img_r.getOp_file_name());

  }
}