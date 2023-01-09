package cl.vicoga.api.stream.tests;

import cl.vicoga.api.stream.model.User;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestStreamFlatMap {

    public static void main(String[] args) {


        Stream<User> names=Stream
                .of("tex text","tax taxt","tix tixt","tux tuxt")
                .map(name-> new User(name.split(" ")[0],name.split(" ")[1]))
                .flatMap(u->{
                    if(u.getName().equals("tex")){
                        return Stream.of(u);
                    }
                    return Stream.empty();
                });




        //names.forEach(System.out::println);

        List<User> u= names.collect(Collectors.toList());

        u.forEach(user -> System.out.println(user.getName()+" "+user.getNick()));











    }

}
