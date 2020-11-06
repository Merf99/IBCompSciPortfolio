package Project2.Adders.Tests;

import Project2.Adders.FullAdder;
import org.junit.Test;

import static org.junit.Assert.*;

public class FullAdderTest {

    @Test
    public void compute1() {
        FullAdder fullAdder = new FullAdder();

        fullAdder.compute(false, false, false);
        assertEquals(false, fullAdder.carry);
        assertEquals(false, fullAdder.sum);

    }
    @Test
    public void compute2() {
        FullAdder fullAdder = new FullAdder();

        fullAdder.compute(false, false, true);
        assertEquals(false, fullAdder.carry);
        assertEquals(true, fullAdder.sum);

    }
    @Test
    public void compute3() {
        FullAdder fullAdder = new FullAdder();

        fullAdder.compute(false, true, false);
        assertEquals(false, fullAdder.carry);
        assertEquals(true, fullAdder.sum);


    }
    @Test
    public void compute4() {
        FullAdder fullAdder = new FullAdder();

        fullAdder.compute(false, true, true);
        assertEquals(true, fullAdder.carry);
        assertEquals(false, fullAdder.sum);


    }
    @Test
    public void compute5() {
        FullAdder fullAdder = new FullAdder();

        fullAdder.compute(true, false, false);
        assertEquals(false, fullAdder.carry);
        assertEquals(true, fullAdder.sum);


    }
    @Test
    public void compute6() {
        FullAdder fullAdder = new FullAdder();

        fullAdder.compute(true, false, true);
        assertEquals(true, fullAdder.carry);
        assertEquals(false, fullAdder.sum);


    }
    @Test
    public void compute7() {
        FullAdder fullAdder = new FullAdder();

        fullAdder.compute(true, true, false);
        assertEquals(true, fullAdder.carry);
        assertEquals(false, fullAdder.sum);


    }
    @Test
    public void compute8() {
        FullAdder fullAdder = new FullAdder();

        fullAdder.compute(true, true, true);
        assertEquals(true, fullAdder.carry);
        assertEquals(true, fullAdder.sum);
    }


}