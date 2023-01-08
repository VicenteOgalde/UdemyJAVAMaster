package cl.vicoga.thread.testsync.runnable;

import cl.vicoga.thread.testsync.BreadFactory;

import java.util.concurrent.ThreadLocalRandom;

public class Baker implements Runnable{

    private BreadFactory breadFactory;

    public Baker(BreadFactory breadFactory) {
        this.breadFactory = breadFactory;
    }

    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {
            breadFactory.bake("bread n "+i);
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(100,600));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

    }
}
