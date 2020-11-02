package Project2.ElementaryLogicGates;

public class Xor {
    public boolean out;


    public Xor() {

    }

    public void compute(boolean a, boolean b){
        if (a==true && b==false){
            out = true;
        }
        else out = a == false && b == true;
    }
}
