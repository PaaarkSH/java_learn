package thejava8.section2;

public class Test implements TestInterface{

    String name;

    public Test(String name) {
        this.name = name;
    }

    @Override
    public void printName() {
        System.out.println(this.name);
    }

    @Override
    public String getName() {
        return this.name;
    }

//    @Override
//    public void printNameUpperCase() {
//        System.out.println(getName().toUpperCase());
//    }

    public static void main(String[] args) {
        Test t = new Test("Park");
        t.printName();
        t.printNameUpperCase();
        TestInterface.printAnything();
    }
}
