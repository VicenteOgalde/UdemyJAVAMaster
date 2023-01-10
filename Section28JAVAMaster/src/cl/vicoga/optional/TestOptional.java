package cl.vicoga.optional;

import java.util.Optional;

public class TestOptional {
    public static void main(String[] args) {

        String name ="tex";

        Optional<String> opNam=Optional.of(name);

        System.out.println("opNam = " + opNam);
        System.out.println("opNam.isPresent() = " + opNam.isPresent());
        if (!opNam.isEmpty() ) {
            System.out.println(opNam.get());
        }
        opNam.ifPresent(o-> System.out.println("hello "+o));

        name=null;

        opNam=Optional.ofNullable(name);

        System.out.println("opNam = " + opNam);

        opNam.ifPresentOrElse(o-> System.out.println("hello "+o)
                ,()-> System.out.println("is empty"));

    }
}
