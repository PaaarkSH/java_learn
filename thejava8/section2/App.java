package thejava8.section2;

import java.util.*;
import java.util.stream.*;

public class App {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("park");
        names.add("kin");
        names.add("lee");
        names.add("choi");

        // names.forEach(System.out::println);

//        Spliterator<String> spliterator = names.spliterator();
//        Spliterator<String> spliterator1 = spliterator.trySplit();
//        while(spliterator.tryAdvance(System.out::println));
//        System.out.println("---------------------------------");
//        while(spliterator1.tryAdvance(System.out::println));

//        names.removeIf(s -> s.startsWith("k"));
//        names.forEach(System.out::println);
        // names.sort(String::compareToIgnoreCase);
//        Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase;
//        names.sort(compareToIgnoreCase);
//        names.sort(compareToIgnoreCase.reversed());

//        Stream<String> stringStream = names.stream().map(String::toUpperCase);
//        names.forEach(System.out::println);
        names.stream().map(s ->{
            System.out.println(s);
            return s.toUpperCase();
        });
        System.out.println("---------------------------------");
        names.forEach(System.out::println);
    }

}
