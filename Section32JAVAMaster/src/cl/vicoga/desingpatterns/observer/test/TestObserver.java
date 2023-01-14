package cl.vicoga.desingpatterns.observer.test;

import cl.vicoga.desingpatterns.observer.Company;

public class TestObserver {
    public static void main(String[] args) {

        Company google = new Company("google",1000);
        google.addObserver((obs,obj)->{
            System.out.println("jon: "+((Company)obs).getName()+
                    " new price:" +((Company)obs).getPrice());
        });
        google.addObserver((obs,obj)->{
            System.out.println("tt: "+((Company)obs).getName()+
                    " new price:" +((Company)obs).getPrice());
        });

        google.setPrice(1500);



    }
}
