package cl.vicoga.api.stream.tests;

import cl.vicoga.api.stream.model.Invoice;
import cl.vicoga.api.stream.model.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestFlatMapInvoice {
    public static void main(String[] args) {


        User u1= new User("asd","dsa");
        User u2= new User("asd2","dsa2");

        Invoice in1= new Invoice("bike");
        Invoice in2= new Invoice("cup");
        Invoice in3= new Invoice("bikes");
        Invoice in4= new Invoice("tv");

        u1.addInvoice(in1);
        u1.addInvoice(in4);
        u2.addInvoice(in2);
        u2.addInvoice(in3);

        List<User> users= Arrays.asList(u1,u2);

        users.stream()
                .flatMap(u->u.getInvoices().stream())
                .forEach(i-> System.out.println
                        (i.getDesc().concat(" client: ")
                                .concat(i.getUser().getName())));




    }
}
