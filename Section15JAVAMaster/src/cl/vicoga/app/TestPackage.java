package cl.vicoga.app;

import cl.vicoga.app.home.Cat;

public class TestPackage {
    public static void main(String[] args) {

        cl.vicoga.app.home.Person p= new cl.vicoga.app.home.Person();
        p.setName("nic");
        System.out.println("p.getName() = " + p.getName());
        Cat cat= new Cat();

    }
}
