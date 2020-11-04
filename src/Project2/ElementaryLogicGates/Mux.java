package Project2.ElementaryLogicGates;

public class Mux {

    public boolean out;
    private Not not1;
    private And and1;
    private And and2;
    private Or or1;

    public Mux() {
        not1 = new Not();
        and1 = new And();
        and2 = new And();
        or1 = new Or();
    }

    public void compute(boolean a, boolean b, boolean sel){
        // compute output and save in boolean 'out'
        not1.compute(sel);
        and1.compute(a,not1.out);
        and2.compute(b,sel);
        or1.compute(and1.out,and2.out);

        out = or1.out;

    }
}
