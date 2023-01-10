package cl.vicoga.api.stream.tests;

import cl.vicoga.api.stream.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class TestStreamParallel {

    public static void main(String[] args) {

        List<User> users= new ArrayList<>();

        users.add(new User("tex","sun"));
        users.add(new User("srD","mon"));
        users.add(new User("tt","moon"));
        users.add(new User("zz","son"));


        Long t1=System.currentTimeMillis();


        String names= users.stream()
                .parallel()
                .map(u->u.getName().toUpperCase()
                .concat(" ")
                .concat(u.getNick().toUpperCase()))
                .flatMap(s->{
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    if(s.contains("mo".toUpperCase())){
                        return Stream.of(s);
                    }
                    return Stream.empty();
                })
                .findAny().orElse("");
        Long t2=System.currentTimeMillis();

        System.out.println("total time "+(t2-t1));
        System.out.println(names);

    }
}
