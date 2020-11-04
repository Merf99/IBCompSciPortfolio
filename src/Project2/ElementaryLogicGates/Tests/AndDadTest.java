package Project2.ElementaryLogicGates.Tests;

import Project2.ElementaryLogicGates.AndDad;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AndDadTest {

    @Test
    public void compute() {
        AndDad and1 = new AndDad();

        and1.compute(true,true);
        assertEquals(true,and1.out);

        and1.compute(true,false);
        assertEquals(false,and1.out);

        and1.compute(false,true);
        assertEquals(false,and1.out);

        and1.compute(false,false);
        assertEquals(false,and1.out);
    }
}