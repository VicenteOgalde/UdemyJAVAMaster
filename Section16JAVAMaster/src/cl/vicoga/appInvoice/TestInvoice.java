package cl.vicoga.appInvoice;

import cl.vicoga.appInvoice.model.Client;
import cl.vicoga.appInvoice.model.Invoice;
import cl.vicoga.appInvoice.model.ItemInvoice;
import cl.vicoga.appInvoice.model.Product;

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
        String name;
        double price;
        int amount;
        System.out.println();

        for(int i=0;i<5;i++){
            p=new Product();
            System.out.print("type product "+p.getId()+"  name: ");
            name=sc.next();
            p.setName(name);
            System.out.print("type product price: ");
            price=sc.nextDouble();
            p.setPrice(price);
            System.out.print("type amount of product: ");
            amount=sc.nextInt();
            ItemInvoice item= new ItemInvoice(amount,p);
            invoice.addItem(item);
            System.out.println();

        }
        System.out.println(invoice.generateDescription());



    }
}
