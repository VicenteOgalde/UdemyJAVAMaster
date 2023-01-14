package cl.vicoga.desingpatterns.observer.test;

import cl.vicoga.desingpatterns.observer.UserRepository;

public class Test2 {
    public static void main(String[] args) {


        UserRepository repository= new UserRepository();

        repository.addObserver((obs,u)-> System.out.println("email for user1 "+ u));

        repository.addObserver((obs,u)-> System.out.println("email for user2 "+ u));

        repository.createUser("tex");

    }
}
