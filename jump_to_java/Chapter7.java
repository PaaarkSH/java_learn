package jump_to_java;

import jump_to_java.singleton.Sample;
import java.util.ArrayList;
import java.util.Arrays;

class FoolException extends Exception{

}

//public class Chapter7 extends Thread{
public class Chapter7 implements Runnable{
    // public void sayNick(String nick) throws FoolException{
    //     // try{
    //     //     if("fool".equals(nick)){
    //     //         // throw new FoolException();
    //     //         throw new FoolException();
    //     //     }
    //     // } catch (FoolException e){
    //     //     System.err.println("FoolException이 발생하였습니다");
    //     // }
    //     if("fool".equals(nick)){
    //         // throw new FoolException();
    //         throw new FoolException();
    //     }
    //
    //     System.out.println("당신의 별명은 " + nick + " 입니다");
    // }
    int seq;
    public Chapter7(int seq){
        this.seq = seq;
    }

    public void run(){  // thread 상속시 구현해줘야됨  // runable 강제구현
        System.out.println(this.seq + "thread start");
        try{
            Thread.sleep(1000);
        } catch (Exception e){

        }
        System.out.println(this.seq + "thread end.");
    }

    public static void main(String[] args){
        // try{
        //     Chapter7 sample = new Chapter7();
        //     sample.sayNick("fool");
        //     sample.sayNick("go");
        // } catch (FoolException e){
        //     System.err.println("FoolException이 발생하였습니다");
        // }

         ArrayList<Thread> threads = new ArrayList<>();
         for (int i = 0; i < 10; i++){
             Thread t = new Thread(new Chapter7(i));
             t.start();  // Thread 클래스를 상속받았기 때문에 start 메소드 실행시 runt 메소드 실행
             threads.add(t);
         }
        //
        // for(int i=0; i<threads.size(); i++){
        //     Thread t = threads.get(i);
        //     try{
        //         t.join();  // t 쓰래드가 종료할때까지 기다린다
        //     } catch(Exception e){
        //
        //     }
        // }

        System.out.println("main end.");
        // 쓰레드가 끝나기전에 메인 메소드가 끝나버림



    }
}


/*
* 패키지: 비슷한 성격의 자바 클래스들을 모아놓은 자바의 디렉터리
*   - 패키지가 다르면 동일한 클래스명 사용 가능
* */


/*
* 접근 제어자
*
* private: 해당 클래스에서만 접근 가능
* default: 해당 패키지 내에서만 접근 가능(아무것도 설정안할경우 이것으로 설정됨)
* protected: 동일 패키지의 클래스 또는 해당클래스를 상속받은 다른 패키지 클래스에서만 접근 가능
* public: 어떤 접근 제어자라도 가능
* */

/*
* static

class HouseLee {
    String name = "이";
}

public class Sample{
    public static void main(String[] args) {
        HouseLee lee1 = new HouseLee();
        HouseLee lee2 = new HouseLee();
    }
}
*
* 다음과 같은 코딩을 할때 객체 마다 name 을 저장하기위한 메모리가 할당된다
* name 이란 값이 변하지 않는 값이라면 static으로 선언할 경우 메모리 이점을 본다
* static String name = "";
* 해당 문장을 선언하면 메모리 할당은 한번만 함으로 이점이 있다.
* final 키워드는 한번 값이 설정되면 변경할수가없다
* static 을 설정하면 같은곳의 메모리만 바라보기 때문에 공유 가능
*/

/*
* 상글톤 패턴
* 닫 하나의 객체만 선언하는 디자인 패턴
*
* */

/*
* 예외처리: 프로그램상 예외가 발생할때제어를 하기 위해서
* Exception 은 크게 두가지로 나뉨
* RuntimeException: 실행시 발생하는 예외
* Exception: 컴파일시 발생하는 예외
*
* 예외처리를 메소드에서 하는게 좋을까 호출부에서 하는게 좋을까? 물론 결과는 똑같음
* 단 메인메소드에서 호출하면 catch로 빠져서 뒷부분이 호출되지 않기 때문에 호출 위치는 잘 알아서...
* */

/*
* 트랜잭션
* - 하나의 작업 단위를 뜻함
* db처럼 해당 작업들이 절차를 맞춰 동작하도 잘못되면 rollback
* 자바에서는 해당 프로그램들이 동작을 하는 과정에서 a 메소드 b메소드 c메소드가 동작을 하던중 c에서 잘못되어을경우
* c메소드의 catch 문에서 해당 과정을 rollback 할수있는 절차를 넣어야된다
* */

/*
* Thread
*
* 객체에 상속하면 interface 라 run 메소드 무조건 구현
* Thread 를 상속받은 함수에서 start() 함수를 실행하면 내부적으로 run 메소드도 돌도록 동작
*
* join: 쓰래드를 돌다보면 밑의 문장이 끝나기 전에 프로ㅔ쓰가 다 돌아버리는데 join으로 쓰래드가 끝나길 기다려줌
*
* */