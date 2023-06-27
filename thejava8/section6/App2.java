package thejava8.section6;

import java.util.concurrent.*;

public class App2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        CompletableFuture<String> future = new CompletableFuture<>();
//        future.complete("hello1");
//        System.out.println(future.get());
//        CompletableFuture<String> future = CompletableFuture.completedFuture("hello");
//        System.out.println(future.get());

//        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
//            System.out.println("hello " + Thread.currentThread().getName());
//        });
//        future.get();

//        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
//            System.out.println("hello " + Thread.currentThread().getName());
//            return "hello";
//        }).thenApply((s) ->{
//            System.out.println(Thread.currentThread().getName());
//            return s.toUpperCase();
//        });

//        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
//            System.out.println("hello " + Thread.currentThread().getName());
//            return "hello";
//        }).thenAccept((s) ->{
//            System.out.println(Thread.currentThread().getName());
//            System.out.println(s.toUpperCase());
//        });

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("hello " + Thread.currentThread().getName());
            return "hello";
        }, executorService).thenRunAsync(() ->{
            System.out.println(Thread.currentThread().getName());
        });

        System.out.println(future.get());

    }
}
