## 1장 자바
#### 자바의 특징
    1. 간단하다
    2. 객체 지향적이다
        - 기본 자료형을 제회한 모데이데이터가 객체로
    3. 인터프리터 언어
        - 정확히 컴파일 언어인 동시에 인터프리터
        - 소스 -> 컴파일 -> .class 파일(이진파일) -> 인터프리트(자바 런타임)
        - 컴퍼일 언어에 가까운 속도와 시스템 독립성
    4. 포인터 연산을 지원하지 않음
        - 가비지 컬렉터(시스템)가 메모리를 해제하는 방식으로 누출 없음
    5. 실행전에 클래스 파일을 이용한 프로그램의 검사 가능
        - 컴파일시 오류를 잡아줌으로 에러 발생률이 적음
    6. 플랫폼 독립적
        - 자바 런타임이 이진파일을 실행하면서 자라 런타임이 존재하는 시스템 어디서든 실행가능
        - 이는 어느 os 에서도 돌려볼수있음
        - jvm 에 의해서 프로그램이 실행되기 때문(덕분에 c보단 속도가 느림)
    7. 멀티쓰레딩 지원
        - 하나의 프로그램 단위가 동일한 쓰레드를 실행가능
    8. 동적
        - 자바 인터페이스를 이용하면 하나의 모듈을 갱신할때 다른 모듈 모두를 갱신할 필요없음
        
#### JDK
    jdk: java developmet kit
        - bin 디렉토리에 javac.exe java.exe 파일이 저장되어있어함
        - jre: java run enviroment
            - 자바가 실행할수있는 최소환경
        - javac: java compiler
            - .java 자바 파일을 실행하기 위해서는 두개의 단계를 거쳐야됨
            - java 소스 작성
            - .java (자바소스) -> 컴파일러 -> .class: 이 단계를 컴파일
            - .class -> jvm -> program
        - 왜 class 라는 중간단계를 거치는가?
            - c 는 중간에 obj exe 파일을 만들수있는데 자바도 가능은 하다
            - 단 jvm이 exe에 포함되는 형식으로 돌아갈거기 때문에 exe가 매우 커진다
            - c c++ 같은 언어는 모든 운영체제에서 동일하게 사용하는것이 불가능
                - 윈도우에서 만든 파일을 리눅스에서 사용불가
            - c c++ 등의 언어는 jvm 같은 중간단계를 안거치기떄문에 빠름
                - 운영체제마다 별도의 실행파일을 작성해야됨
            - 자바는 jvm 이라는 중간단계가 있어서 느리지만 어떤 os 에서도 사용 가능
                - jit 같은 하드웨어 직접 제어하는 케이스면 비슷한 속도 가능


#### 자바 키워드
    abstract  continue  for         new        switch
    assert    default   goto        package    synchronized
    boolean   do        if          private    this
    break     double    implements  protected  throw
    byte      else      import      public     throws
    case      enum      instanceof  return     transient
    catch     extends   int         short      try
    char      final     interface   static     void
    class     finally   long        strictfp   volatile
    const     float     native      super      while


#### 자바 명명규칙
    1. 클래스명은 명사  ex) Cookie
        - camelcase
    2. 메소드명은 동사  ex) run()
    3. 변수명


#### 자료형
    1. 숫자
        - 정수: int long (byte short)
            -2147483648 ~ 2147483647
            -9223372036854775808 ~ 9223372036854775807
        - 실수: float double
            - float: 슷자 끝에 f
            - double
        - 8진수: ex) 023
        - 16잔수: ex) 0xC
    2. 나머지는 구지 쓸필요없더라
    3. 문자열
        - String a = "hi" 랑 String a = new String("hi") 는 완전히 동일하지않다
            - 1번 방식을 리터럴이라고 표기: 객체 생성없이 고정된 값 그대로 대입
                - 문자열을 intern pool 이라는 곳에 저장하고 동일한 문자열이 선언될때 cache 된 문자열 리턴
            - 2번 방식은 그냥 새로운 String 객체 생성
    4. 원시 자료형
        - int long float boolean char 등은 new 키워드로 생성 불가
        - 오직 리터럴로만 값을 세팅
        - String 은 리터럴로 표기는 가능한데 원시 자료형은 아님
    5. wrapper 클래스
        - int: Integer
        - long: Long
        - double: Double
        - float: Float
        - boolean: Boolean
        - char: Char
        - 원시 자료형 대신 wrapper 클래스를 사용하면 값 대신 객체를 주고받을 수 있어 객체중심적 작성 가능
        - 멀티쓰래딩 환경에서 동기를 지원하기위해 꼭 필요
