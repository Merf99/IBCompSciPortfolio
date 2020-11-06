package Project2.Adders.Tests;

import Project2.Adders.HalfAdder;
import org.junit.Test;

import static org.junit.Assert.*;

public class HalfAdderTest {

    @Test
    public void compute1() {
        HalfAdder halfAdder = new HalfAdder();
        halfAdder.compute(true, true);
        assertEquals(false, halfAdder.sum);
        assertEquals(true, halfAdder.carry);


    }
    @Test
    public void compute2() {
        HalfAdder halfAdder = new HalfAdder();

        halfAdder.compute(true, false);
        assertEquals(true, halfAdder.sum);
        assertEquals(false, halfAdder.carry);


    }
    @Test
    public void compute3() {
        HalfAdder halfAdder = new HalfAdder();

        halfAdder.compute(false, true);
        assertEquals(true, halfAdder.sum);
        assertEquals(false, halfAdder.carry);


    }
    @Test
    public void compute4() {
        HalfAdder halfAdder = new HalfAdder();

        halfAdder.compute(false, false);
        assertEquals(false, halfAdder.sum);
        assertEquals(false, halfAdder.carry);


    }
}