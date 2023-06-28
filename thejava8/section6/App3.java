package thejava8.section6;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class App3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

//        CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
//            System.out.println("hello" + Thread.currentThread().getName());
//            return "hello";
//        });
//
//        CompletableFuture<String> world = CompletableFuture.supplyAsync(() -> {
//            System.out.println("world" + Thread.currentThread().getName());
//            return "world";
//        });

//        CompletableFuture<String> future = hello.thenCombine(world, (h, w) -> h + " " + w);
//        System.out.println(future.get());
//        CompletableFuture<String> future = hello.thenCompose(App3::getWorld);
//        System.out.println(future.get());

//        List<CompletableFuture<String>> futures = Arrays.asList(hello, world);
//
//        CompletableFuture[] futuresArray = futures.toArray(new CompletableFuture[futures.size()]);
//        CompletableFuture<List<String>> results = CompletableFuture.allOf(futuresArray)
//                .thenApply(v -> {  // thenApply 가 실행되는 시점에는 모든 작업이 끝남
//                    return futures.stream()
//                            .map(CompletableFuture::join)
//                            .collect(Collectors.toList());
//                    // get 은 try catch로 묶어야되는게 번거로움
//                    // join 이랑 get이랑은 작업은 같긴하지만 문제가 생기면 unchecked excpetion 발생
//                });
//
//        results.get().forEach(System.out::println);

//        CompletableFuture<Void> future = CompletableFuture.anyOf(hello, world).thenAccept(System.out::println);
//        future.get();

        boolean throwError = true;
//        CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
//            if(throwError){
//                throw new IllegalArgumentException();
//            }
//            System.out.println("hello" + Thread.currentThread().getName());
//            return "hello";
//        }).exceptionally(ex ->{
//            System.out.println(ex);
//            return "Error!";
//        });

        CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
            if(throwError){
                throw new IllegalArgumentException();
            }
            System.out.println("hello" + Thread.currentThread().getName());
            return "hello";
        }).handle((result, ex) ->{
           if (ex != null){
               System.out.println(ex);
               return "ERROR";
           }
           return result;
        });

        System.out.println(hello.get());
    }

//    private static CompletableFuture<String> getWorld(String msg) {
//        return CompletableFuture.supplyAsync(() -> {
//            System.out.println("world" + Thread.currentThread().getName());
//            return msg + "world";
//        });
//    }
}
