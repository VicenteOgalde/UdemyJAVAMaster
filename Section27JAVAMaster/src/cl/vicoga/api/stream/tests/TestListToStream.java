package cl.vicoga.api.stream.tests;

import cl.vicoga.api.stream.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class TestListToStream {

    public static void main(String[] args) {

        List<User> users= new ArrayList<>();

        users.add(new User("tex","sun"));
        users.add(new User("srD","mon"));
        users.add(new User("tt","moon"));
        users.add(new User("zz","son"));

        Stream<String> names= users.stream().map(u->u.getName().toUpperCase()
                .concat(" ")
                .concat(u.getNick().toUpperCase()))
                .flatMap(s->{
                    if(s.contains("mo".toUpperCase())){
                        return Stream.of(s);
                    }
                    return Stream.empty();
                })
                .peek(System.out::println);

        names.forEach(System.out::println);

    }
}
