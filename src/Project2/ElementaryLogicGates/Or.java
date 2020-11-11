package Project2.ElementaryLogicGates;

public class Or {

    public boolean out;
    private Xor xor1;
    private Xor xor2;
    private And and1;

    public Or() {
        xor1 = new Xor();
        xor2 = new Xor();
        and1 = new And();
    }

    public void compute(boolean a, boolean b){
        and1.compute(a,b);
        xor1.compute(a,b);
        xor2.compute(and1.out,xor1.out);

        out = xor2.out;
    }

}
