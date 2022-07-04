package jump_to_java.house.person;  // 패키지가 housepark 이랑 다름

import jump_to_java.house.HousePark;

public class EungYongPark extends HousePark{
    public static void main(String[] args){
        EungYongPark eyp = new EungYongPark();
        System.out.println(eyp.lastname);  // 상속된 클래스의 protected 변수는 접근 가능
    }
}
