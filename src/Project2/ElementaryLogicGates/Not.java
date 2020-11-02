package Project2.ElementaryLogicGates;

public class Not {
    public boolean out;

    public Not() {

    }

    public void compute(boolean in){
        if (in==true){
            out = false;
        }
        else {
            out = true;
        }
    }

}
