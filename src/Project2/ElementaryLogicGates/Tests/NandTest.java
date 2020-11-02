package Project2.ElementaryLogicGates.Tests;

import Project2.ElementaryLogicGates.Nand;
import org.junit.Test;
//import org.testng.annotations.Test;

import static org.junit.Assert.*;

public class NandTest {

    @Test
    public void compute() {
        Nand nand1=new Nand();
        assertEquals(false,nand1.out);

        nand1.compute(false,true);
        assertEquals(true,nand1.out);

        nand1.compute(true,false);
        assertEquals(true,nand1.out);

        nand1.compute(false,false);
        assertEquals(true,nand1.out);

    }
}