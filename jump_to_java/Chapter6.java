package jump_to_java;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;  // j2se 5.0 이후로 추가. 자바 콘솔입출력 전용 클래스


public class Chapter6 {
    public static void main(String[] args) throws IOException {
        // InputStream in = System.in;
        // int a = in.read();  // 입력을 계속 기다려서 입력받을 값을 아스키코드 int 값으로 반환

        // 만약 입력을 여러번 받고싶다면?
        // byte[] a = new byte[3];
        // in.read(a);

        // System.out.println(a[0]);
        // System.out.println(a[1]);
        // System.out.println(a[2]);

        //InputStreamReader reader = new InputStreamReader(in);
        // char[] a = new char[3];
        // reader.read(a);
        // System.out.println(a);

        // BufferedReader bf = new BufferedReader(reader);

        // String a = bf.readLine();
        // System.out.println(a);
        // Scanner s = new Scanner(System.in);
        // System.out.println(s.next());

        // FileOutputStream output = new FileOutputStream("/Users/parksanghun/java_learn/jump_to_java/out.txt");
        //        for (int i=1; i<11; i++){
        //            String data = i + " 번째 줄입니다.\r\n";  // \r은 윈도우 노트패드같은 에디터에서 줄바꿈이 제대로 안될때 사용
        //            output.write(data.getBytes());  // 문자열을 바이트단위 배열로 리턴하는 함수
        //        }

        // FileWriter fw = new FileWriter("/Users/parksanghun/java_learn/jump_to_java/out.txt");
        // for (int i=1; i<11; i++){
        //     String data = i + " 번째 줄입니다.\r\n";  // \r은 윈도우 노트패드같은 에디터에서 줄바꿈이 제대로 안될때 사용
        //     fw.write(data);  // 문자열을 바이트단위 배열로 리턴하는 함수
        // }

        // PrintWriter pw = new PrintWriter("/Users/parksanghun/java_learn/jump_to_java/out.txt");
        //
        // for (int i=1; i<11; i++){
        //     String data = i + " 번째 줄입니다.";  // \r은 윈도우 노트패드같은 에디터에서 줄바꿈이 제대로 안될때 사용
        //     pw.println(data);  // 문자열을 바이트단위 배열로 리턴하는 함수
        // }
        // pw.close();
        // // 이후 파일을 수정해서 다시 쓰고싶다면?
        //
        // // FileWriter("/Users/parksanghun/java_learn/jump_to_java/out.txt", true)  // 매개변수에 true 전달
        // PrintWriter pw2 = new PrintWriter(new FileWriter("/Users/parksanghun/java_learn/jump_to_java/out.txt", true));
        //
        // for (int i=11; i<21; i++){
        //     String data = i + " 번째 줄입니다.";  // \r은 윈도우 노트패드같은 에디터에서 줄바꿈이 제대로 안될때 사용
        //     pw2.println(data);  // 문자열을 바이트단위 배열로 리턴하는 함수
        // }
        // pw2.close();

        BufferedReader br = new BufferedReader(new FileReader("/Users/parksanghun/java_learn/jump_to_java/out.txt"));
        while(true){
            String line = br.readLine();
            if (line == null) break;
            System.out.println(line);
        }
        br.close();
    }
}


/*
* 콘솔 입력
* InputStream은 자바 내장 클래스
* String, System 같은 클래스는 java.lang 패키지 안에 속해있는 클래스여서 별도의 import가 필요없음
* IOException: InputStream 으로 값을 읽을때 오류가 발생할수있어서 예외처리 필요
*
* Stream: 시작과 끝이 있는 데이터가 전송되는 흐름
*   - 파일 데이터
*   - http 송수신 데이터
*   - 키보드 입력
*
* InputStream: byte
* InputStreamReader: character
* BufferedReader: String
*
* Scanner 클래스
* next: 단어
* nextLine: 라인
* nextInt: 정수
* */

/*
* 콘솔 출력
* System.out.println
* System.out은 PrintStream 클래스의 객체
* System.err: System.out과 동일한 역활을 하지만 오류 메세지를 출력할 경우만 사용(유닉스의 경우 해당 내용이 별도의 파일로 저장)
* */

/*
* 파일입출력
*
* */