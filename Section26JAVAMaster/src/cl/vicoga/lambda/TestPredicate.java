package cl.vicoga.lambda;

import cl.vicoga.lambda.model.User;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class TestPredicate {

    public static void main(String[] args) {

        Predicate<Integer> predicate=num->num>10;
        System.out.println(predicate.test(5));

        BiPredicate<String, User> biPredicate= (s,u)->u.getName().equals(s);

        User user= new User();
        user.setName("top");
        System.out.println(biPredicate.test("top",user));

    }
}
