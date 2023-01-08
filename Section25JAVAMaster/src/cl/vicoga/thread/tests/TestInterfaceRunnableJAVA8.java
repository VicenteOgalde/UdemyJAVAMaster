package cl.vicoga.thread.tests;

import cl.vicoga.thread.tests.runnable.TravelTask;

public class TestInterfaceRunnableJAVA8 {
    public static void main(String[] args) {

        Runnable travel = new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<10;i++){
                    System.out.println(i+" - "+Thread.currentThread());
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("finish execution");
            }
        };

        Runnable travel2 = ()-> {
            for (int i=0;i<10;i++){
                    System.out.println(i+" - "+Thread.currentThread());
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("finish execution");
           };


        new Thread(travel,"paris").start();
        new Thread(travel,"Usa").start();
        new Thread(travel2,"UK").start();



    }
}
