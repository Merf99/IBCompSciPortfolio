package Project2.ElementaryLogicGates.Tests;

import Project2.ElementaryLogicGates.Dmux;
import org.junit.Test;

import static org.junit.Assert.*;

public class DmuxTest {

    @Test
    public void compute1() {
        Dmux dmux1 = new Dmux();

        dmux1.compute(false,false);
        assertEquals(false,dmux1.a);
        assertEquals(false,dmux1.b);
    }
    @Test
    public void compute2() {
        Dmux dmux1 = new Dmux();

        dmux1.compute(true, false);
        assertEquals(true, dmux1.a);
        assertEquals(false, dmux1.b);
    }
    @Test
    public void compute3() {
        Dmux dmux1 = new Dmux();

        dmux1.compute(false, true);
        assertEquals(false, dmux1.a);
        assertEquals(false, dmux1.b);

    }
    @Test
    public void compute4() {
        Dmux dmux1 = new Dmux();

        dmux1.compute(true, true);
        assertEquals(false, dmux1.a);
        assertEquals(true, dmux1.b);
    }
    }