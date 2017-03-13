import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by vlado on 12.03.17.
 */
public class LifeSimTest {

    @Test
    public void setVirtualFieldEven() throws Exception {
        LifeSim sim = new LifeSim(2,2);
        sim.setVirtualField(0,0);
        String actualField = sim.getFieldPrint();
        assertEquals("00\n01\n", actualField);
    }

    @Test
    public void setVirtualFieldOdd() throws Exception {
        LifeSim sim = new LifeSim(3,3);
        sim.setVirtualField(0,0);
//        sim.print();
        assertEquals("000\n010\n000\n", sim.getFieldPrint());
    }

    /* 00100
     * 01110
     * 01010
     * 00100 */
    @Test
    public void initSmallExploderTest() throws Exception {
        LifeSim sim = new LifeSim(5,4);
        sim.initSmallExploder();
        assertEquals("00100\n01110\n01010\n00100\n", sim.getFieldPrint());
    }

    /* 0000
     * 0010
     * 0001
     * 0111 */
    @Test
    public void initGliderTest() throws Exception {
        LifeSim sim = new LifeSim(4,4);
        sim.initGlider();
        //sim.print();
        assertEquals("0000\n0010\n0001\n0111\n", sim.getFieldPrint());

    }
}