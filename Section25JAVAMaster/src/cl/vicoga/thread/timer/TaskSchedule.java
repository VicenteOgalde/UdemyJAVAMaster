package cl.vicoga.thread.timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TaskSchedule {
    public static void main(String[] args) {

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Task date "
                +new Date()+" name of the thread "+
                        Thread.currentThread().getName());
                System.out.println("Finish");
                timer.cancel();
            }
        },5000);

        System.out.println("task after 5 sec : "+new Date());

    }
}
