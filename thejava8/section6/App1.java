package thejava8.section6;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class App1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
        ExecutorService executorService = Executors.newFixedThreadPool(2);

//        Future<String> helloFuture = executorService.submit(hello);
//        System.out.println("Started!");
//
////        helloFuture.get();
//        helloFuture.cancel(false);
//
//        System.out.println(helloFuture.isDone());
//        System.out.println("End!");
//        executorService.shutdown();
        Callable<String> hello2 = () -> {
            Thread.sleep(2000L);
            return "hello2";
        };

        Callable<String> hello3 = () -> {
            Thread.sleep(3000L);
            return "hello3";
        };

        Callable<String> hello4 = () -> {
            Thread.sleep(4000L);
            return "hello4";
        };
        Callable<String> hello1 = () -> {
            Thread.sleep(1000L);
            return "hello1";
        };
//        List<Future<String>> futures = executorService.invokeAll(Arrays.asList(hello1, hello2, hello3, hello4));
//        for(Future<String> f: futures){
//            System.out.println(f.get());
//        }
        String s = executorService.invokeAny(Arrays.asList(hello1, hello2, hello3, hello4));
        System.out.println(s);
        executorService.shutdown();
    }
}
