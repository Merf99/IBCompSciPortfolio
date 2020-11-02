package Project2.ElementaryLogicGates;

public class Xor {
    public boolean out;


    public Xor() {

    }

    public void compute(boolean a, boolean b){
        if (a==true && b==false){
            out = true;
        }
        else if (a==false && b==true){
            out = true;
        }
        else {
            out = false;
        }
    }
}
