package cl.vicoga.lambda.math;

import java.util.function.BiFunction;

public class Calculator {

    public double compute(double a, double b,Maths m) {
        return m.operation(a,b);
    }

    public  double computeBiFunction(Double a, Double b, BiFunction<Double,Double,Double> bi){
        return bi.apply(a,b);
    }
}
