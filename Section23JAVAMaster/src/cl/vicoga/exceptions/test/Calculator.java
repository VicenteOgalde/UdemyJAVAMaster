package cl.vicoga.exceptions.test;

public class Calculator {

    public static double divide(int x,int z) throws DivideZeroException {
        if(z==0){
            throw  new DivideZeroException("you cant divide by zero");
        }
        return x/(double)z;
    }

}
