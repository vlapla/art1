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
        String message = "No Exception";
        SimpleField testField = new SimpleField(10,10);
        try {
            testField.getNeighbourSum(11, 10);
        } catch (AssertionError ae1){ // an AssertionError is expected!
            message = ae1.getMessage();
        }
        assertEquals("X-Wert außerhalb der Feldgröße versucht!", message);
    }

    @Test
    public void neighborSumIsTwo() throws Exception {
        SimpleField testField = new SimpleField(10,10);
        testField.setField(2,1, 1);
        testField.setField(2,2, 1);
        int neighborSum = testField.getNeighbourSum(1,1);
        assertEquals(2, neighborSum);
    }

    @Test
    public void neighborSumIsEight() throws Exception {
        SimpleField testField = new SimpleField(10,10);
        testField.setField(1,1, 1);
        testField.setField(2,1, 1);
        testField.setField(3,1, 1);
        testField.setField(1,2, 1);
        testField.setField(3,2, 1);
        testField.setField(1,3, 1);
        testField.setField(2,3, 1);
        testField.setField(3,3, 1);
//        System.out.println(testField.toString()); // Visual check
        int neighborSum = testField.getNeighbourSum(2,2);
        assertEquals(8, neighborSum);
    }


    @Test
    public void initFourByFourBlankField() throws Exception {
        SimpleField testField = new SimpleField(4,4);
        String f = testField.toString();
        assertEquals("0000\n0000\n0000\n0000\n", f);
    }

    /* 0010
     * 0000
     * 0000
     * 0001 */
    @Test
    public void initFourByFourFieldPattern() throws Exception {
        SimpleField testField = new SimpleField(4,4);
        testField.setField(3, 1, 1);
        testField.setField(4, 4, 1);
        String f = testField.toString();
        assertEquals("0010\n0000\n0000\n0001\n", f);
    }



}