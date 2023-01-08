package cl.vicoga.thread.testsync;

public class BreadFactory {

    private String bread;
    private boolean available;

    public synchronized void bake(String pm){
        while (available){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        this.bread=pm;
        System.out.println("baker make "+this.bread);
        this.available=true;
        notify();

    }
    public synchronized  String consume() {
        while (!available){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("client consume "+this.bread);
        this.available=false;
        notify();
        return this.bread;
    }
}
