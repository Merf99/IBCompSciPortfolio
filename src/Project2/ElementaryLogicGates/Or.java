package Project2.ElementaryLogicGates;

public class Or {

    public boolean out;


    public Or() {

    }

    public void compute(boolean a, boolean b){
        if (a == true||b == true){
            out = true;
        }
        else {
            out = false;
        }
    }

}
