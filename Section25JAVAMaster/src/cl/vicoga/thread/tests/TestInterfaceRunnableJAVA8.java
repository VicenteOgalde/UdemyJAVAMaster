package cl.vicoga.thread.tests;

import cl.vicoga.thread.tests.runnable.TravelTask;

public class TestInterfaceRunnableJAVA8 {
    public static void main(String[] args) throws InterruptedException {

        Thread main= Thread.currentThread();


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
                System.out.println("state main thread: "+main.getState());
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
            System.out.println("state main thread: "+main.getState());
                System.out.println("finish execution");
           };


        Thread t1= new Thread(travel,"paris");
        Thread t2= new Thread(travel,"Usa");
        Thread t3= new Thread(travel2,"UK");

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("continue main method.....");



    }
}
