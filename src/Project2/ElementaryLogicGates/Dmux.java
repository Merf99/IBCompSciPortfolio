package Project2.ElementaryLogicGates;

public class Dmux {

    public boolean a;
    public boolean b;
    private And and1;
    private And and2;
    private Not not1;

    public Dmux() {
        and1 = new And();
        and2 = new And();
        not1 = new Not();
    }

    public void compute(boolean in, boolean sel){
        and1.compute(in,sel);
        not1.compute(sel);
        and2.compute(in,not1.out);

        a = and2.out;
        b = and1.out;

    }
}
