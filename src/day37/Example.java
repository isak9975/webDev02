package day37;

public class Example {

    // 함수 정의/생성/선언/만들기 vs 함수 호출/사용
    // 함수를 호출하는 방법
        //1. [  static main 함수 안에서 함수 호출 방법 ]
            //1. 동일한 클래스 이면
                    //(1) 호출할 함수도 static 이여야 한다.
                    //(2) 객체를 생성해서 호출해야한다
        //2. 다른 클래스내 함수 이면
                //( 일반함수 1) 객체를 생성해서 호출해야한다.
                //(static  함수 2) 클래스명.static 함수명() 호출 가능하다(싱글톤)
        //2.[ static 아닌 함수 안에서 다른 함수 호출 방법]
            //1. 동일한 클래스 함수이면
                //(1)함수명만 작성해여 호출한다
                //(static  함수 2) 클래스명.static 함수명() 호출 가능하다(싱글톤)
        //3. 싱글톤내 포함된 함수이면
                //클래스명.getInstance().함수명()
    static  void 함수1(){}
    void 함수3(){}
    void 함수4(){
        함수4();
    }

    public static void main(String[] args) {
        //1-1
        함수1();

        //1-2
        OBJ obj = new OBJ();
        obj.함수2();

    }

}
