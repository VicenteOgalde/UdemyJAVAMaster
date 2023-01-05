package cl.vicoga.exceptions.test;

public class Calculator {

    public static double divide(int x,int z) throws DivideZeroException {
        if(z==0){
            throw  new DivideZeroException("you cant divide by zero");
        }
        return x/(double)z;
    }
    public double divide(String a,String b) throws DivideZeroException, FormatNumberException {
        int n1, n2;
        n1 = Integer.parseInt(a);
        n2 = Integer.parseInt(b);
        return divide(n1, n2);
    }

}
