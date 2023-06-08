package thejava8.section2;

import java.util.*;
import java.util.stream.*;

public class App {

    public static void main(String[] args) {
        List<String> name = new ArrayList<>();
        name.add("park");
        name.add("kin");
        name.add("lee");
        name.add("choi");

        // name.forEach(System.out::println);

//        Spliterator<String> spliterator = name.spliterator();
//        Spliterator<String> spliterator1 = spliterator.trySplit();
//        while(spliterator.tryAdvance(System.out::println));
//        System.out.println("---------------------------------");
//        while(spliterator1.tryAdvance(System.out::println));

//        name.removeIf(s -> s.startsWith("k"));
//        name.forEach(System.out::println);
        // name.sort(String::compareToIgnoreCase);
        Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase;
        name.sort(compareToIgnoreCase);
        name.sort(compareToIgnoreCase.reversed());
    }

}
