import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Created by vlado on 06.03.17.
 */
public class SimpleFieldTest {
    @Test
    public void neighborSumIsZero() throws Exception {
        SimpleField testField = new SimpleField(10,10);
        int neighborSum = testField.getNeighbourSum(1,1);
        assertEquals(0, neighborSum);
    }

    @Test
    public void neighborSumOutOfBoundary() throws Exception {
        SimpleField testField = new SimpleField(10,10);
        try {
            int neighborSum = testField.getNeighbourSum(11, 10);
        } catch (AssertionError ae1){ // an AssertionError is expected!
            assertEquals("X-Wert außerhalb der Feldgröße versucht!", ae1.getMessage());
        }
    }

    @Test
    public void neighborSumIsTwo() throws Exception {
        SimpleField testField = new SimpleField(10,10);
        testField.setField(2,1, 1);
        testField.setField(2,2, 1);
        int neighborSum = testField.getNeighbourSum(1,1);
//        testField.printField();
        assertEquals(2, neighborSum);
    }

    public void initFourByFourBlankField() throws Exception {
        SimpleField testField = new SimpleField(10,10);

    }

}