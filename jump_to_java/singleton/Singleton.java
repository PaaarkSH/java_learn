package jump_to_java.singleton;

public class Singleton {
    private static Singleton one;
    private Singleton(){

    }
    public static Singleton getInstance() {
        if(one == null){
            one = new Singleton();// 같은 클래스 안이여서 생성자 호출이 가능함
        }
        return one;
    }
}
