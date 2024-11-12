/*
    BoardService6
        -BoardService4 모든 코드를 복사후 진행
        -추가조건 : Board 클래스 객체들을 캡슐화(접근제한자)하시오.
            -1.NewBoard는 앞전 board와 동일하게 내용[String타입]과 작성자[String타입]과 비밀번호[int타입]
            -2.NewBoard의 모든 필드(멤벼변수)는 private 으로 선언한다
            -3.외부에서 객체 생성시 생성자를 사용한다.
            -4.getter(필드값호출함수), setter(필드값대입 함수),toString(객체정보함수)


            public : 공개용, 모든 클래스/ 패키지 내에서 접근가능
            private : 배공개용, 현재 클래스내에서 접근가능
                -이유: 객체의 자료는 중요하기 때문에 쉽게 저장/ 변경 하면 안된다.(유효성 검사 1.원하는 데이터인지 2.안전한 데이터인지)
                -객체를 통해 필드 직접 접근을 차닪나고 간접접근을 이요한 유효성 검사를 시행한다.
            protected : 동일한 패키지 내에서 접근 가능, 상속 관계이면 다른 패키지에서도 접근가능하다
            (default) : 동일한 패키지 내에서 접근 가능, 접근제한자를 생략 했을 때 기본적으로 적용되는 접근재한자.

*/
package day22;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class BoardService6 {
    public static void main(String[] args) {
        //-입력 객체
        Scanner scan = new Scanner(System.in);
        //-컬렉션 프레임 워크중 ArrayList 클래스를 이용한 배열 대체 한다.
        //배열(고정길이) vs 컬렉션프레임워크(가변길이)
        ArrayList<Board> boardList= new ArrayList<>();
        //ArrayList<제네릭타입> : 리스트객체 저장할 객체의 타입

        while (true) {
            System.out.println("1.글쓰기, 2.글출력 : ");
            int choose = scan.nextInt();
            if(choose ==1){
                System.out.print("내용 : ");  String content = scan.next();
                //.next() 문자열(공백x) , .nextLine() 문자열(공백o,엔터o
                // .nextLine() 사용시 주의하 점: .nextLine() 앞에 또다른 .nextXX있으면 씹힘
                //(해결방법) .nextLine 위쪽에 의미 없는 .nextLine 한줄 작성
                System.out.print("작성자 : "); String writer  = scan.next();
                System.out.print("비밀번호: "); int pwd = scan.nextInt();
                //[2]입력 받은 데이터로 게시물 객체 생성
                Board board = new Board(); //- 게시물 객체 생성
                board.content = content; board.writer = writer; board.pwd = pwd;
                //[3]컬렉션 프레임워크인 게시물을 만들어 저장한다.

                boardList.add(board);


            } else if(choose == 2){
                for(int index = 0; index <= boardList.size()-1 ; index++){

                    System.out.printf("작성자 : %s, 내용 : %s%n ", boardList.get(index).writer, boardList.get(index).content);

                }

            }

        }


    }
}
