package cl.vicoga.thread.tests;

import cl.vicoga.thread.tests.runnable.PrintPhrase;

public class TestSyncThread {

    public static void main(String[] args) throws InterruptedException {

        Thread t1=new Thread(new PrintPhrase("who ","are you?"));

        Thread t2=new Thread(new PrintPhrase("i am ","Batman"));

        Thread t3=new Thread(new PrintPhrase("..... "," really?"));

        t1.start();
        t1.join();
        t2.start();
        t2.join();
        t3.start();
        t3.join();

    }

    public static synchronized void printPhrase(String p1,String p2){

        System.out.print(p1);

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        System.out.println(p2);


    }
}
