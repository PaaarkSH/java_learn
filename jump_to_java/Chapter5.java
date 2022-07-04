package jump_to_java;


//interface Predator {
abstract class Predator extends Animal{
    abstract String getFood();  // 인터페이스는 선언만하고 implements 한 클래스가 구현

//    default void printFood(){  // 디폴트 메소드
    void printFood(){  // 디폴트 메소드
        // 자바 8 부터 디폴트메소드를 사용가능
        // 인터페이스의 메소드는 구현 불가능하지만 디폴트 메소드는 가능
        // 오버라이딩도 가능
        System.out.printf("my food is %s\n", getFood());
    }
    static int LEG_COUNT = 4;  // 인터페이스 상수 // 추상클래스의 상수는 static 선언 필요함
    // 인터페이스 상수는 public static finale 을 생략해도 자동으로 정의된다
    static int speed(){
        return LEG_COUNT * 30;
    }
}

interface Barckable {
    void bark();
}

interface BarkablePredator extends  Barckable{
    // 인터페이스는 다중상속 가능
}

class Animal{
    String name = "";

    void setName(String name){
        this.name = name;
    }
}

class Dog extends Animal{
    void sleep(){
        System.out.println(this.name + " zzz");
    }
}

class HouseDog extends Dog{
    void sleep() {System.out.println(this.name + " zzz in house");}  // method overriding
    void sleep(int hour) {System.out.println(this.name + " zzz in house for" + hour + " hours");}  //method overloading

}

class Tiger extends Predator implements Barckable{
    // 상속과 같은 개념으로 is-a 관계가 적용됨
    // Tiger is Predator

    public String getFood(){
        return "apple";
    }

    public void bark(){
        System.out.println("어흥");
    }
}

class Lion extends Predator implements Barckable{
    public String getFood(){
        return "banana";
    }
    public void bark(){
        System.out.println("으르렁");
    }
}

class ZooKeeper {
//    void feed(Tiger tiger){
//        System.out.println("feed apple");
//    }
//    void feed(Lion lion){
//        System.out.println("feed banana");
//    }
    void feed(Predator Predator){
        System.out.println("feed " + Predator.getFood());
    }
    // 이제 주요 클래스를 작성하는 입장에서 구현체(lion tiger 등) 와 상관없이 인터페이스를 기준으로 중요 클래스를 작성해야됨
}

class Bouncer {
    void barkAnimal(Barckable animal){
//        if (animal instanceof Tiger){
//            System.out.println("어흥");
//        } else if (animal instanceof Lion){
//            System.out.println("으르렁");
//        }
        animal.bark();
    }
}



public class Chapter5 {
    /*
    * 객체와 인스턴스
    * 클래스에 의해 만들어진 객체를 인스턴스라고 한다
    * Animal cat = new Animal();
    * cat은 객체
    * cat은 Animal 클래스의 인스턴스
    * 과자틀 -> 클래스
    * 과자 -> 객체
    * */

    /*
    * 객체변수: 객체에 추가된 변수(인스턴스 변수, 멤버변수, 속성)
    * */

    public static void main(String[] args){

        /*
        * 상속
        * dog 클래스는 animal 클래스를 상속했다. 즉 dog 는 animal의 하위 개념이라고 할수있다
        * 이런 관계를 is-a 라고 한다
        * */

        // Dog dog = new Dog();
        // dog.setName("poppy");
        // System.out.println(dog.name);
        // dog.sleep();

        // Animal dog1 = new Dog();  // 이런 코딩도 가능함
        // 단 이런 코딩을 할 경우에는 dog1 이 dog 클래스의 함수들을 사용할수없고 animal 만 가능하다
        // 즉 부모로 만든 객체는 자식 클래스 자료형으로 사용 불가

        // Dog dog2 = new Animal();  // 부모 클래스로 만든 객체는 자식클래스의 자료형으로 사용 못한다

        /*
        * object 클래스
        * 자바의 모든 클래스는 object 클래스에서 상속받는다.
        * 자바의 모든클래스는 extends object 를 선언하지 않더라도 자동으로 상속받도록 되어있다
        * 따라서
        * Object animal = new Animal();
        * Object dog = new Dog();
        * */

        /*
        * 메소드 오버라이딩: 부모클래스의 메소드를 자식클래스가 동일한 형태로 다시 구현
        * 메소드 오버로딩: 입력항목이 다를경우 동일한 이름의 메소드로 선언
        * */
        // HouseDog houseDog = new HouseDog();
        // houseDog.setName("happy");
        // houseDog.sleep();
        // houseDog.sleep(3);

        /*
        * 다중상속
        * c++ 파이썬 같은 언어들은 다중상속을 지원하지만 자바는 다중 상속을 지원하지 않음
        * 다중상속을 한 이후에 부모 클래스에서 같은 이름의 함수에서 다른 동작을 지원할때
        * class C extends A, B {
           public void static main(String[] args) {
                C test = new C();
                test.msg();
                }
            }
            * 이런 형태로 메소드를 호출할경우 애매모호한 부분이 생긴다
            * 자바는 이런 애매한 부분을 다 제거했다(다른 언어들은 우선순위를 적용하여 해결한다)
       * */

        /*
        * 생성자: 객체 생성시에 필수적인 행동들을 객체 생성에서 제어할수있다
        * */

        /*
        * 인터페이스
        * 해당 문법에서 zookeeper 가 간단한 데이터만 있다면 편하겠지만 계속 추가가 된다면 클래스에 불필요한 요소들이 늘어난다
        * 핵심개념
        * 인터페이스의 한개의 매소드로 주요 클래스의 여러개 메소드에서 1개의 매소드로 구현 가능
        * 여기서 핵심은 메소드의 갯수가 줄은게 아닌 서브 클래스의 의존적인 메인 클래스에서 독립적인 클래스로 변한점
        * 상속과 다른점은 상속을 받는다 하더라도 메소드를 강제로 오버라이딩 할 필요는 없지만 인터페이스는 강제 구현
        * */
        // ZooKeeper zooKeeper = new ZooKeeper();
        // Tiger tiger = new Tiger();
        // Lion lion = new Lion();

        // zooKeeper.feed(lion);
        // zooKeeper.feed(tiger);

        /*
        * 다형성
        *
        * 다형성을 통해서 메인 클래스에서 서브 클래스인지 insatanceof 해가면서 구지 찾을 필요없이
        * 추상클래스의 메소드를 통해서 돋립적인 클래스에서 관리 가능
        * 다형성을 이용하면 복잡한 형태의 분기문 간단하게 처리 가능
        * tiger lion 은 각각 tiger lion 클래스의 객체이면서 Animal 클래스의 객체이고 Barkable Predator 인터페이스의 객체이다
        * 이렇게 여러개의 자료형 타입을 가질 수 있는것을 다형성이라고 한다
        *
        * */
//         Tiger tiger = new Tiger();
//         Lion lion = new Lion();

//         Bouncer bouncer = new Bouncer();
//         bouncer.barkAnimal(tiger);
//         bouncer.barkAnimal(lion);

//        Tiger tiger = new Tiger();
//        Animal animal = new Tiger();
//        Predator Predator = new Tiger();
//        Barckable barckable = new Tiger();

        /*
        * 추상 클래스: 인터페이스의 역활도 하고 클래스의 역활도함
        * 혹자는 추상클래스를 인터페이스로 대체하는게 좋은 디자인
        * 추상클래스는 인터페이스 사용이 불가해서 extend 선언해야됨
        * 자바 8 버전부터 인터페이스에 default 메소드가 추가되어 추상클래스와 차이점이 모호해졌다
        * 추상클래스는 인터페이스와 달리 일반 클래스처럼 객체변수, 생성자, private 매소드 등을 가질수있다
        * */

    }


    /*
     * 해당 두 객체는 변수값이 독립적이라 서로 같은 함수를 호출하여도 값을 독립적으로 유지한다
     * */

    // 메소드: 클래스 내의 존재하는 함수

    /*
     * 매개변수(parameter): 메소드에 입력으로 전달된 값을 받는 변수
     * 인수(argument): 메소드를 호출할때 전달받는 입력값
     * 같은 의미를 가지는 용어라 햇갈리지 않도록 주의
     * int sum(int a, int b){  // a, b 는 매개변수
     * sample.sum(3, 4) // 3, 4는 인수
     * */

    // 로컬변수: 메소드 내에서만 사용하는 함수
    /*
     * public int test(int a){ a++; }
     * 해당 함수가 메인 메소드 내에서 사용해도 메인 메소드에서 호출할때 사용한 변수랑은 서로 무관함
     * 결론적으로 primitive 자료형인지 reference 자료형인지에 따라 나
     * */

    /*
     * call by value
     * 메소드에 원시값과 객체값을 전달하는것에 큰 차이가 있음
     * 인수값이 전달받은 이후에도 변경하길 원한다면 객체값으로 넘겨서 계산
     * */

}

