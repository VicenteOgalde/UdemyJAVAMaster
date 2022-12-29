package cl.vicoga.appInvoice;

import cl.vicoga.appInvoice.model.*;


import java.util.Scanner;

public class TestInvoice {
    public static void main(String[] args) {

        Client cl= new Client();
        cl.setName("user1");
        cl.setRut("17.852");
        Scanner sc= new Scanner(System.in);
        System.out.println("type invoice description: ");
        String desc=sc.nextLine();
        Invoice invoice= new Invoice(desc,cl);
        Product p;

        System.out.println();

        for(int i=0;i<5;i++){
            p=new Product();
            System.out.print("type product "+p.getId()+"  name: ");

            p.setName(sc.next());
            System.out.print("type product price: ");

            p.setPrice(sc.nextDouble());
            System.out.print("type amount of product: ");

            invoice.addItem(new ItemInvoice(sc.nextInt(),p));
            System.out.println();

        }
        System.out.println(invoice.generateDescription());



    }
}
