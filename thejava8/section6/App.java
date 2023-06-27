package thejava8.section6;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args){
//        ExecutorService executorService = Executors.newFixedThreadPool(2);
//        executorService.submit(getRunnable("hello1"));
//        executorService.submit(getRunnable("hello2"));
//        executorService.submit(getRunnable("hello3"));
//        executorService.submit(getRunnable("hello4"));
//        executorService.submit(getRunnable("hello5"));
//        executorService.shutdown();  // grace

        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(getRunnable("hello"), 1, 2, TimeUnit.SECONDS);
        // shutdown 이 interrupt 을 발생해서 기다리지 않고 종료함
    }

    private static Runnable getRunnable(String msg) {
        return () -> {
            System.out.println(msg + Thread.currentThread().getName());
        };
    }
}
