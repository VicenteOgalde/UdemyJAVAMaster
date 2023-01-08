package cl.vicoga.thread.testsync.runnable;

import cl.vicoga.thread.testsync.BreadFactory;

import java.util.concurrent.ThreadLocalRandom;

public class Client implements Runnable{

    private BreadFactory breadFactory;

    public Client(BreadFactory breadFactory) {
        this.breadFactory = breadFactory;
    }

    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {
            breadFactory.consume();


        }
    }
}
