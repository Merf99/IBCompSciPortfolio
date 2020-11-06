package Project2.Adders;

import Project2.ElementaryLogicGates.And;
import Project2.ElementaryLogicGates.Xor;

public class HalfAdder {
    public boolean sum;
    public boolean carry;
    private And and1;
    private Xor xor1;

    public HalfAdder() {
        and1 = new And();
        xor1 = new Xor();
    }

    public void compute(boolean a, boolean b){
        and1.compute(a,b);
        xor1.compute(a,b);
        carry = and1.out;
        sum = xor1.out;

    }

}
