package thejava8.section3;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        System.out.println("Spring 으로 시작하는 수업");
        springClasses.stream()
                .filter(s -> s.getTitle().startsWith("Spring"))  // 중개 오퍼레이터
                .forEach(x -> System.out.println(x.getId()))  // 종료 오퍼레이터 void
        ;

        System.out.println("close 되지 않는 수업");
        springClasses.stream()
                // .filter(s -> !s.isClosed())
                .filter(Predicate.not(OnlineClass::isClosed))  // method reference 에 not 을 넣을 수 없음
                .forEach(s -> System.out.println(s.getId()))
        ;

        System.out.println("수업 이름만 모아서 스트림 만들기");
        // todo
        springClasses.stream()
                .map(OnlineClass::getTitle)
                .forEach(System.out::println);
        ;

        List<OnlineClass> javaClasses = new ArrayList<>();
        javaClasses.add(new OnlineClass(6, "The Java, Test", true));
        javaClasses.add(new OnlineClass(6, "The Java, Code manipulation", true));
        javaClasses.add(new OnlineClass(6, "The Java, 8 to 11", true));

        List<List<OnlineClass>> keesunEvents = new ArrayList<>();
        keesunEvents.add(springClasses);
        keesunEvents.add(javaClasses);

        System.out.println("두 수업 목록에 들어있는 모든 수업 아이디 출력");
        // todo
        // list 안에 list 가 두개 있음
        keesunEvents.stream()
                .flatMap(Collection::stream)  // list -> 각각의 클래스로
                .forEach(oc -> System.out.println(oc.getId()))
        ;
        System.out.println("10부터 1씩 증가하는 무제한 스트림 중에서 앞에 10개 빼고 최대 10개 까지만");
        // todo
        Stream.iterate(10, i -> i+1)
                .skip(10)
                .limit(10)
                .forEach(System.out::println)
        ;

        System.out.println("자바 수업 중에 Test 가 들어있는 수업이 있는지 확인");
        // todo
        boolean test = javaClasses.stream().anyMatch(oc -> oc.getTitle().contains("Test"));
        System.out.println(test);
        System.out.println("스프링 수업 중에 제목에 spring 이 들어간 제목만 모아서 List로 만들기");
        // todo
        List<String> spring = javaClasses.stream()
                .filter(oc -> oc.getTitle().contains("spring"))
                .map(OnlineClass::getTitle)
                .collect(Collectors.toList());
        // map 이랑 filter 의 순서에 따라 어떤게 올지 달라짐
        spring.forEach(System.out::println);
    }
}
