package jump_to_java;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;

public class Chapter3 {
    public void string_test() {
        // equal
        String a = "hello";
        String b = new String("hello");
        System.out.println(a.equals(b));  // true
        System.out.println(a == b);  // false  // 동일한 객체인지 판별하기 위해 사용하는 연산자라 false

        // indexOf
        a = "hello java";
        System.out.println(a.contains("java"));

        // char at
        a = "hello java";
        System.out.println(a.charAt(6));

        // replace
        a = "hello java";
        System.out.println(a.replace("hello", "world"));

        // toUpperCase
        a = "hello java";
        System.out.println(a.toUpperCase());

        // split
        a = "a:b:c:d";
        System.out.println(a.split(":"));

        // 문자열 포매팅
        System.out.println(String.format("i eat %d apples.", 3));

        System.out.println(String.format("i eat %s apples.", "five"));

        /*
        %s 문자열 %d 정수 %c 문자 1개 %f float  %o 8진수 %x 16진수 %% 문자 %그 자체
        */

        System.out.printf("i eat %d apples.%n", 3);  // 포매팅된 문자 자체를 리턴

        // StringBuffer: 문자열을 추가하거나 변경할떄 사용하는 자료형

        StringBuffer sb = new StringBuffer();
        sb.append("hi");
        String result = sb.toString();
        System.out.println(result);

        /*
        * StringBuffer로 문자를 만드는것과 그냥 문자열 += 으로 선언하는것은 결과만 동일하고 객체가 생성되고 메모리가 사용되는 과정은 다르다
        * StringBuffer는 객체가 한번 사용되고 +=은 연산될때마다 새로운 String 객체를 생성한다
        * String 자체가 값이 변환하는것처럼 보이지만 또다른 객체를 생성해서 리턴할 뿐
        * 하지만 StringBuffer는 mutable
        *
        * StringBuffer는 String 자료형모다 메모리 사용량도 많고 속도도 느리다
        * 따라서 문자열 추가나 변경이 많을 경우 사용하는게 좋고 변경 작업이 거의 없을경우 그냥 String 이 좋다
        * */

        // insert
        sb = new StringBuffer();
        sb.append("hello");
        sb.insert(0, "hi ");
        System.out.println(sb.toString());


        //substring
        sb = new StringBuffer("hello");
        System.out.println(sb.substring(0, 4));

        // 배열 뭐 귀찮으니 pass

        /*
        * list 자료형
        * list 자료형에는 ArrayList Vector LinkedList 등의 리스트 인터페이스를 구현한 자료형이 있다
        *
        * */

        // ArrayList

        ArrayList arr = new ArrayList();
        arr.add("1");
        arr.add("2");
        arr.add("3");

        /*
        * 제네릭스
        *
        * 자바는 j2se 5.0 버전 이후부터 ArrayList<String> arr = new ArrayList<>(); 와 같이 객체를 포함하는 자료형도 어떤 객체를 표현할지 명확하게 표현하라고 권고함
        * 아니면 warning 뜸
        * */
        // 인덱스값
        System.out.println(arr.get(1));

        // 갯수 리턴
        System.out.println(arr.size());

        // 값을 가지고 있는지
        System.out.println(arr.contains("4"));

        // remove
        /*
        * remove 방식에 2가지가있음 remove(객체) remove(인덱스)
        * */

        System.out.println(arr.remove("2"));
        System.out.println(arr.remove(0));


        // 제네릭스
        /*
        * j2se 5.0 이후부터 도입
        * <> 안에 자료형만 담을수있다는 뜻
        * 해당 데이터는 형변환할 필요가 없음
        * */

        ArrayList<String> s_arr1 = new ArrayList<String>();
        s_arr1.add("1");
        s_arr1.add("2");
        s_arr1.add("3");

        String[] data = {"1", "2", "3"};

        ArrayList<String> s_arr2 = new ArrayList<>(Arrays.asList(data));
        System.out.println(s_arr2);

        ArrayList<String> s_arr3 = new ArrayList<>(Arrays.asList("1", "2", "3"));
        System.out.println(s_arr3);

        // String.join
        String rst_arr3 = String.join(",", s_arr3);
        System.out.println(rst_arr3);
        System.out.println(String.join(",", data));

        // sort

        ArrayList<String> arr4 = new ArrayList<>(Arrays.asList("3", "2", "1"));
        arr4.sort(Comparator.naturalOrder());  // 오름차순 정렬
        System.out.println(arr4);  // '1' '2' '3'

        /*
        * Map
        * */

        HashMap<String, String> map = new HashMap<>();
        map.put("a", "1");
        map.put("b", "2");
        map.put("c", "3");

        System.out.println(map.get("a"));
        System.out.println(map.get("d"));  //  없는거는 null
        /*
        *  get을 했을때 해당하는 값이 없으면 Null
        *  디폴트값이 있고싶으면 getOrDefault
        * */
        System.out.println(map.getOrDefault("d", "0"));

        System.out.println(map.containsKey("a"));  // 키가 있는지
        System.out.println(map.containsValue("1"));  // 값이 있는지
        System.out.println(map.size());  // 해당 map의 사이즈가 얼마인지
        System.out.println(map.keySet());  // 키들 모아서 전체 출력 베얄 출략

        /*
        * linkedHashMap TreeMap
        * 그냥 맵 때려박을때는 map
        * linkedHashMap 순서있는거
        * TreeMap 입력한 애들을 오름차순으로 정렬
        * */
        /*
        집합
        같은 데이터가 들어가는 것들 제외

         */

        HashSet<String> set1 = new HashSet<>(Arrays.asList("a", "a", "c"));
        System.out.println(set1);

        HashSet<Integer> h1 = new HashSet<>(Arrays.asList(1,2,3));
        HashSet<Integer> h2 = new HashSet<>(Arrays.asList(2,3,4));
        HashSet<Integer> intersection = new HashSet<>(h1);  // s1
        intersection.retainAll(h2);  // 교집합
        System.out.println(intersection);

        HashSet<Integer> union = new HashSet<>(h1);
        union.addAll(h2);  // 합집합
        System.out.println(union);

        // 집합관련된거 볼필요없을것같은데 넘어가자


        // enum: 특정 상수값 넘길때 숫자보다 명확
        enum CoffeeType {
            AMERICANO,
            LATTE
        }
        System.out.println(CoffeeType.AMERICANO);
        for(CoffeeType type: CoffeeType.values()){
            System.out.println(type);
        }

        /*
        * wrapper 클래스를 통해서 형변환도 가능하고 Integer.pa
        * */
        String num1 = "1";
        System.out.println(Integer.parseInt(num1));

    }


}
