package cl.vicoga.lambda;

import cl.vicoga.lambda.math.Calculator;
import cl.vicoga.lambda.math.Maths;

public class TestInterfaceFunctional {
    public static void main(String[] args) {


        Maths sum = Double::sum;
        Maths divide=(a,b)->a/b;
        Calculator c = new Calculator();

        System.out.println(sum.operation(5,5));
        System.out.println("divide 10 / 2 = "+divide.operation(10,2));
        System.out.println("multiply "+c.computeBiFunction(5.0,5.0,(a,b)-> a*b));



    }
}
