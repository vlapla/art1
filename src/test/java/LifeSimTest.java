import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by vlado on 12.03.17.
 */
public class LifeSimTest {

    @Test
    public void setVirtualFieldEven() throws Exception {
        LifeSim sim = new LifeSim(6,6);
        sim.setVirtualField(1,1,1);
        sim.print();
    }

    @Test
    public void setVirtualFieldOdd() throws Exception {
        LifeSim sim = new LifeSim(5,5);
        sim.setVirtualField(1,1,1);
        sim.print();
    }

    @Test
    public void initSmallExploder() throws Exception {

    }

}