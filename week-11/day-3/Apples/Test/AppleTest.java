import org.junit.Test;

import static org.junit.Assert.*;

public class AppleTest {

    @Test
    public void getApple() {
        Apple apple = new Apple();
        String expectedResult = "apple";

        String result = apple.getApple();

        assertEquals(expectedResult, result);
    }

}