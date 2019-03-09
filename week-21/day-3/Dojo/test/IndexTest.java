import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IndexTest {

  private static Index indexInstance;

  @BeforeClass
  public static void init() {
    indexInstance = new Index();
  }

  @Test
  public void givesMinus1AsResult() {
    List<Object> list = new ArrayList<>(Arrays.asList(0));
    Object value = 1;
    int expectedValue = -1;

    int result = indexInstance.findIndex(list, value);
    assertEquals(expectedValue, result);
  }

  @Test
  public void withNoList() {
    List<Object> list = null;
    Object value = 1;
    int expectedValue = -1;

    int result = indexInstance.findIndex(list, value);

    assertEquals(expectedValue, result);
  }

  @Test
  public void listWithOneElementWhichFits() {
    List<Object> list = new ArrayList<>(Arrays.asList(1));
    Object value = 1;
    int expectedValue = 0;

    int result = indexInstance.findIndex(list, value);

    assertEquals(expectedValue, result);
  }

  @Test
  public void stringListWithOneElementWhichFits() {
    List<Object> list = new ArrayList<>(Arrays.asList("a"));
    Object value = new String("a");
    int expectedValue = 0;

    int result = indexInstance.findIndex(list, value);

    assertEquals(expectedValue, result);
  }

}
