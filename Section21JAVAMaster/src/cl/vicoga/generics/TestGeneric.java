package cl.vicoga.generics;

import cl.vicoga.model.Client;
import cl.vicoga.model.ClientVIP;

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

        List<ClientVIP> vipList= fromArrayToList(new ClientVIP[]{new ClientVIP("vip1"
        ),new ClientVIP("vip22")});

        printClient(vipList);

    }
    public static <T> List<T> fromArrayToList(T [] c){
        return Arrays.asList(c);
    }
    public static <T extends Number> List<T> fromArrayToList(T [] c){//only for numbers
        return Arrays.asList(c);
    }
    public static void printClient(List<? extends Client> c){
        c.forEach(System.out::println);
    }
}
