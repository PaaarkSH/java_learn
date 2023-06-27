package thejava8.section6;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class App3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
            System.out.println("hello" + Thread.currentThread().getName());
            return "hello";
        });

        CompletableFuture<String> world = CompletableFuture.supplyAsync(() -> {
            System.out.println("world" + Thread.currentThread().getName());
            return "world";
        });

        hello.thenCombine(world, )

//        CompletableFuture<String> future = hello.thenCompose(App3::getWorld);
//        System.out.println(future.get());
    }

//    private static CompletableFuture<String> getWorld(String msg) {
//        return CompletableFuture.supplyAsync(() -> {
//            System.out.println("world" + Thread.currentThread().getName());
//            return msg + "world";
//        });
//    }
}
