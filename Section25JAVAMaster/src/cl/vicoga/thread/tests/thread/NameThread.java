package cl.vicoga.thread.tests.thread;

public class NameThread extends Thread{
    public NameThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("start run method "+getName());

        for (int i=0;i<10;i++){
            System.out.println(this.getName());
        }
        System.out.println("end of method run");

    }
}
