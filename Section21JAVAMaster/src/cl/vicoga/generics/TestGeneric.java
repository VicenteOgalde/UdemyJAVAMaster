package cl.vicoga.generics;

import cl.vicoga.model.Client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestGeneric {

    public static void main(String[] args) {

        List clients = new ArrayList();

        clients.add(new Client("Tex"));

        Client[] cli={new Client("tt"),new Client("toto")};

        clients.addAll(fromArrayToList(cli));

        clients.forEach(System.out::println);

    }
    public static <T> List<T> fromArrayToList(T [] c){
        return Arrays.asList(c);
    }
}
