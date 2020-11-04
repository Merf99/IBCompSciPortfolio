package Project2.ElementaryLogicGates.Tests;

import Project2.ElementaryLogicGates.Mux;
import org.junit.Test;

import static org.junit.Assert.*;

public class MuxTest {

    @Test
    public void compute1() {
        Mux mux1 = new Mux();

        mux1.compute(false,false,false);
        assertFalse(mux1.out);
    }
    @Test
    public void compute2() {
        Mux mux1 = new Mux();

        mux1.compute(false,true,false);
        assertFalse(mux1.out);
    }
    @Test
    public void compute3() {
        Mux mux1 = new Mux();

        mux1.compute(true,false,false);
        assertTrue(mux1.out);

    }
    @Test
    public void compute4() {
        Mux mux1 = new Mux();

        mux1.compute(true,true,false);
        assertTrue(mux1.out);

    }
    @Test
    public void compute5() {
        Mux mux1 = new Mux();

        mux1.compute(false,false,true);
        assertFalse(mux1.out);
    }
    @Test
    public void compute6() {
        Mux mux1 = new Mux();

        mux1.compute(false,true,true);
        assertTrue(mux1.out);
    }
    @Test
    public void compute7() {
        Mux mux1 = new Mux();

        mux1.compute(true,false,true);
        assertFalse(mux1.out);
    }
    @Test
    public void compute8() {
        Mux mux1 = new Mux();

        mux1.compute(true,true,true);
        assertTrue(mux1.out);

    }
}