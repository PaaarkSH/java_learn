package thejava8.section2;

public interface Bar extends TestInterface{
    default void printNameUpperCase(){
        System.out.println("BAR");
    }
}
