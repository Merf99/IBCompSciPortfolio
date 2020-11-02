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


    }
}
