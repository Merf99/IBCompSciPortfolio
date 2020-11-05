package Project2.ElementaryLogicGates.Tests;

import Project2.ElementaryLogicGates.AndDad;
import org.junit.Test;

import static org.junit.Assert.*;

public class AndDadTest {

    @Test
    public void compute() {
        AndDad and1 = new AndDad();

        and1.compute(true,true);
        assertTrue(and1.out);

        and1.compute(true,false);
        assertFalse(and1.out);

        and1.compute(false,true);
        assertFalse(and1.out);

        and1.compute(false,false);
        assertFalse(and1.out);
    }
}