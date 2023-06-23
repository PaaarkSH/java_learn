package thejava8.section4;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class App2 {
    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        Optional<OnlineClass> optional = springClasses.stream()
                // .filter(oc -> oc.getTitle().startsWith("spring"))
                .filter(oc -> oc.getTitle().startsWith("jpa"))
                .findFirst();

        boolean present = optional.isPresent();
        System.out.println(present);

        //OnlineClass onlineClass1 = onlineClass.get();
        //onlineClass.ifPresent(oc -> System.out.println(oc.getTitle()));
        //OnlineClass onlineClass1 = onlineClass.orElse(createNewClass());
        // OnlineClass onlineClass1 = onlineClass.orElseGet(App2::createNewClass);

//        OnlineClass onlineClass = optional.orElseThrow(() ->{
//            return new IllegalArgumentException();
//        });
//        OnlineClass onlineClass = optional.orElseThrow(IllegalStateException::new);
//        System.out.println(onlineClass.getTitle());

        Optional<OnlineClass> onlineClass = optional.stream()
                .filter(OnlineClass::isClosed)
                .findFirst()
        ;
        System.out.println(onlineClass.isEmpty());

        //Optional<Optional<Progress>> progress = optional.map(OnlineClass::getProgress);
        Optional<Progress> progress = optional.flatMap(OnlineClass::getProgress);



    }

    private static OnlineClass createNewClass() {
        System.out.println("create new online class");
        return new OnlineClass(10, "new class", false);
    }
}
