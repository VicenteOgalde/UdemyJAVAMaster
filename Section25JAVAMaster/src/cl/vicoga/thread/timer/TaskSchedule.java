package cl.vicoga.thread.timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

public class TaskSchedule {
    public static void main(String[] args) {

        AtomicInteger ai= new AtomicInteger(3);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                int count=ai.getAndDecrement();
                if (count>0) {
                    System.out.println("Task date "
                            + new Date() + " name of the thread " +
                            Thread.currentThread().getName());
                }else {
                    System.out.println("Finish");
                    timer.cancel();
                }
            }
        },1000,1000);

        System.out.println("task after 5 sec : "+new Date());

    }
}
