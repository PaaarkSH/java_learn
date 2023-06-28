package thejava8.section7;

import java.util.Arrays;
import java.util.List;

@Chicken("양념1")
@Chicken("양념2")
@Chicken("양념3")
@Chicken("양념4")
@Chicken("양념5")

public class App {
    public static void main(String[] args){
//        Chicken[] chickens = App.class.getAnnotationsByType(Chicken.class);
//        Arrays.stream(chickens).forEach(System.out::println);
        ChickenContainer chickenContainer = App.class.getAnnotation(ChickenContainer.class);
        Arrays.stream(chickenContainer.value()).forEach(c->{
            System.out.println(c.value());
        });
    }
}
