package cl.vicoga.thread.tests.runnable;

import static cl.vicoga.thread.tests.TestSyncThread.printPhrase;

public class PrintPhrase implements Runnable{

    private String p1,p2;

    public PrintPhrase(String p1, String p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    @Override
    public void run() {

        printPhrase(this.p1,this.p2);


    }
}
