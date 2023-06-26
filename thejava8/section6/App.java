package thejava8.section6;

public class App {
    public static void main(String[] args) throws InterruptedException {
//        System.out.println(Thread.currentThread().getName());  // 메인 쓰레드
//        MyThread myThread = new MyThread();
//        myThread.start();

//        System.out.println("Hello");
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Thread : " + Thread.currentThread().getName());
//            }
//        });
//        thread.start();

//        Thread thread = new Thread(() ->  System.out.println("Thread : " + Thread.currentThread().getName()));
//        thread.start();

        Thread thread = new Thread(() ->  {
            System.out.println("Thread : " + Thread.currentThread().getName());
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e){
                throw new IllegalStateException(e);
            }
        });
        thread.start();

        System.out.println("Hello : " + Thread.currentThread().getName());
        try {
            thread.join();  // 기다린다
        } catch (InterruptedException e){
            e.printStackTrace();
        }


        System.out.println(thread + "is finished");
    }
//    static class MyThread extends Thread {
//        @Override
//        public void run(){
//            System.out.println("hello : " + Thread.currentThread().getName());
//        }
//    }
}
