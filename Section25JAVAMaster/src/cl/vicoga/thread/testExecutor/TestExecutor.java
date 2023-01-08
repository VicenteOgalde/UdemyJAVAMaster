package cl.vicoga.thread.testExecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TestExecutor {
    public static void main(String[] args) throws InterruptedException {


        ExecutorService executorService= Executors.newSingleThreadExecutor();

        Runnable task=()->{
            System.out.println("start Task");
            try {
                System.out.println("thread name "+Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        };

        executorService.submit(task);
        executorService.shutdown();
        System.out.println("execute main 1");
        executorService.awaitTermination(2,TimeUnit.SECONDS);
        System.out.println("execute main 2");

    }
}
