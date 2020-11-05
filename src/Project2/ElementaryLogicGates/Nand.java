package Project2.ElementaryLogicGates;

public class Nand {

    public boolean out;

    public Nand() {
    }

    public void compute(boolean a, boolean b){

        if (a==true && b==true){
            out = false;
        }
        else{
            out=true;
        }
    }


}
