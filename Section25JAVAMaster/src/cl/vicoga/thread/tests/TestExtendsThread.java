package cl.vicoga.thread.tests;

import cl.vicoga.thread.tests.thread.NameThread;

public class TestExtendsThread {
    public static void main(String[] args) {

        Thread thread = new NameThread("thread 1");
        thread.start();

        Thread thread2 = new NameThread("thread 2");
        thread.start();
        

        System.out.println(thread.getState());



    }
}
