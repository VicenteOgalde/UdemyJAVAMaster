package cl.vicoga.thread.testsync;

import cl.vicoga.thread.testsync.runnable.Baker;
import cl.vicoga.thread.testsync.runnable.Client;

import java.util.concurrent.ThreadLocalRandom;

public class TestProductAndClientSyncJava8 {
    public static void main(String[] args) {

        BreadFactory bf = new BreadFactory();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                bf.bake("bread n: "+(i+1));
                try {
                    Thread.sleep(ThreadLocalRandom.current().nextInt(100,500));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                bf.consume();

            }
        }).start();


    }
}
