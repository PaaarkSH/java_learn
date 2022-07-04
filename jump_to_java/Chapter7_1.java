package jump_to_java;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

//@FunctionalInterface  // 2개 이상의 메소드를 가진 인터페이스 구현 불가
//interface Calculator{
//    int sum(int a, int b);
//}

/*
 * 함수형 프로그래밍
 * 람다(lambda): 익명함수
 *  - 인터페이스로 구현되있는 함수를 한줄로 바로 선언해서 사용 가능
 *  - 단 인터페이스 함수 2줄 이상부터 구현 불가 (FunctionalInterface 통해서 선언 더 못하도록 수정)
 *  - BiFunction 인터페이스를 이용하면 따로 인터페이스를 만들어서 선언을 할 필요가 없어짐
 *  - BinaryOperator: 매개변수랑 리턴값이 동일한 형태면 더 쉽게 사용 가능
 * 스트림(Stream):
 * */
// public class Chapter7_1 {
//     public static void main(String[] args){
//         // Calculator mc = (a, b) -> a + b;
//         // Calculator mc = Integer::sum;
//         // 결과값이 Integer.sum(int a, int b)와 같기 떄문에 축약
//         // :: 기호를 통해 클래스와 메소드 구분
//
//         // BiFunction<Integer, Integer, Integer> mc = (a, b) -> a + b;  // 입력 2개 출력 1개
//         BinaryOperator<Integer> mc = (a, b) -> a + b;  // 입력 출력의 타입만 넣어서 사용 가능
//         int result = mc.apply(3, 4);
//         System.out.println(result);
//     }
// }


import java.util.Arrays;
import java.util.Comparator;

/*
* 스트림(Stream): 물결처럼 흐르면서 필터링 과정을 통해 여러번 변경되어 변환
*
* */
public class Chapter7_1 {
    public static void main(String[] args){
        /*
        * 문제! 해당 배열을 짝수만 모아 중복을 제거하고 역순으로 출력하시오
        * {5, 6, 4, 2, 3, 1, 1, 2, 2, 4, 8};
        *
        * */
        int[] data = {5, 6, 4, 2, 3, 1, 1, 2, 2, 4, 8};
        int[] result = Arrays.stream(data)  // intsteam 생성
                .boxed()  // intStream을 Stream<Integer> 로 변경
                .filter((a) -> a % 2 == 0)  // 짝수만 걸러네ㅐ고
                .distinct()  // 중복 제거
                .sorted(Comparator.reverseOrder())  // 역순으로 정렬
                .mapToInt(Integer::intValue)  // Stream<Integer> 를 IntStream으로 변경
                .toArray()  // int 배열로 변경
        ;
    }
}