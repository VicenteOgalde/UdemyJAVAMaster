package cl.vicoga.lambda;

import cl.vicoga.lambda.model.User;

import java.util.function.BiFunction;
import java.util.function.Function;

public class TestFunction {
    public static void main(String[] args) {


        Function<String,String> f = param ->"hello "+param;

        System.out.println(f.apply("tt"));

        Function<String,Integer> fn = String::length;

        System.out.println("number or char in world is "+fn.apply("world"));


        User user= new User();
        BiFunction<User,String,User> biFunction=(a,b)->{
            a.setName(b);
            return a;
        };

        System.out.println(biFunction.apply(user,"zed"));



    }
}
