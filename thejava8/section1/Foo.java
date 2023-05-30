package thejava8.section1;

import java.lang.FunctionalInterface;
import java.util.function.*;

public class Foo {
    public static void main(String[] args) {
        int base = 10;
        // RunSomething runSomething = (number) -> number + base;
        // System.out.println(runSomething.doIt(1));

        // Plus10 plus10 = new Plus10();
        // System.out.println(plus10.apply(1));

//        Function<Integer, Integer> plus10 = (i) -> i + 10;
//        Function<Integer, Integer> multiply2 = (i) -> i * 2;
//
//        Function<Integer, Integer> multiply2AndPlus10 = plus10.compose(multiply2);
//        System.out.println(multiply2AndPlus10.apply(2));
//
//        System.out.println(plus10.andThen(multiply2).apply(2));
//
//        Consumer<Integer> printT = (i) -> System.out.println(i);
//        printT.accept(10);
//
//        Supplier<Integer> get10 = () -> 10;
//        System.out.println(get10.get());
//
//        Predicate<String> stringPredicate = (s) -> s.startsWith("keesun");
//
//        UnaryOperator<Integer> plus10New = (i) -> i + 10;

        Supplier<Integer> get10 = () ->10;
        BinaryOperator<Integer> sum = (Integer a, Integer b) -> a + b;
        // 타입은 이미 변수 선언부에 있기 떄문에 생략 해도 됨
        
        Foo foo = new Foo();
        foo.run();
    }

    private void run() {
//        int baseNumber = 10;

//        class LocalClass {
//            int baseNumber = 11;
//            void printBaseNumber(){
//                System.out.println(baseNumber);
//            }
//        }
//
//        Consumer<Integer> integerConsumer = new Consumer<Integer>() {
//            @Override
//            public void accept(Integer integer) {
//                System.out.println(baseNumber);
//            }
//        };
        int baseNumber = 10;
        IntConsumer printInt = (i) -> System.out.println(i + baseNumber);
        printInt.accept(10);
//        baseNumber++;
    }
}
