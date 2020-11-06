package Project2.Adders;

import Project2.ElementaryLogicGates.And;
import Project2.ElementaryLogicGates.Or;
import Project2.ElementaryLogicGates.Xor;

public class FullAdder {
    public boolean sum;
    public boolean carry;
    private Xor xor1;
    private Xor xor2;
    private And and1;
    private And and2;
    private Or or1;

    public FullAdder() {
        xor1 = new Xor();
        xor2 = new Xor();
        and1 = new And();
        and2 = new And();
        or1 = new Or();
    }

    public void compute(boolean a, boolean b, boolean c){
        xor1.compute(a,b);
        xor2.compute(xor1.out,c);
        and1.compute(a,b);
        and2.compute(xor1.out,c);
        or1.compute(and1.out,and2.out);

        sum = xor2.out;
        carry= or1.out;
    }
}
