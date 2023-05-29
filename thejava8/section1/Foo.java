package thejava8.section1;

public class Foo {
    public static void main(String[] args) {
        int base = 10;
    RunSomething runSomething = (number) -> number + base;
        System.out.println(runSomething.doIt(1));
    }
}
