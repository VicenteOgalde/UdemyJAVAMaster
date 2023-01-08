package cl.vicoga.thread.tests.runnable;

public class TravelTask implements Runnable{

    private String name;

    public TravelTask(String name){
        this.name=name;
    }

    public String getName(){ return this.name;}

    @Override
    public void run() {

        for (int i=0;i<10;i++){
            System.out.println(i+" - "+getName());
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("finish execution");

    }
}
