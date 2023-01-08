package cl.vicoga.thread.tests;

import cl.vicoga.thread.tests.runnable.TravelTask;

public class TestInterfaceRunnable {
    public static void main(String[] args) {


        new Thread(new TravelTask("paris")).start();
        new Thread(new TravelTask("USA")).start();



    }
}
