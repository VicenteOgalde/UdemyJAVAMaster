package cl.vicoga.thread.testExecutor;

import java.util.concurrent.*;

public class TestExecutorFuture {
    public static void main(String[] args) throws InterruptedException, ExecutionException {


        ExecutorService executorService= Executors.newSingleThreadExecutor();

        Callable<String> task=()->{
            System.out.println("start Task");
            try {
                System.out.println("thread name "+Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
            return "great work";
        };

        Future<String> result= executorService.submit(task);
        executorService.shutdown();
        System.out.println("execute main 1");

        System.out.println(result.isDone());

        System.out.println(result.get());
    }
}
