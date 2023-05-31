package thejava8.section1;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class App {
    public static void main(String[] args) {
//        UnaryOperator<String> hi = Greeting::hi;
//        Greeting greeting = new Greeting();
//        UnaryOperator<String> hi = greeting::hello;
//        Supplier<Greeting> greetingSupplier = Greeting::new;
//        Function<String, Greeting> newGreeting = Greeting::new;
//        Greeting park = newGreeting.apply("park");
//        System.out.println(park.getName());
        String[] names = {"park", "keesun", "whiteship"};
        Arrays.sort(names, String::compareToIgnoreCase);
        System.out.println(Arrays.toString(names));
    }
}
