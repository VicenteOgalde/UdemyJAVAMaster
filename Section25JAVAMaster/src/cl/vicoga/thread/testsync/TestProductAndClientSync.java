package cl.vicoga.thread.testsync;

import cl.vicoga.thread.testsync.runnable.Baker;
import cl.vicoga.thread.testsync.runnable.Client;

public class TestProductAndClientSync {
    public static void main(String[] args) {

        BreadFactory bf = new BreadFactory();

        new Thread(new Baker(bf)).start();

        new Thread(new Client(bf)).start();


    }
}
