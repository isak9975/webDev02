/*
BoardService3
    -내용[String타입] 과 작성자[String타입]과 비밀번호 [int타입]으로 구성도니 게시물을 구성
    -게시물 객체 최대 100개 까지 저장하는 서비스 구축
        조건 : main함수 1개와 배열은 최대1까지 사용하여 구션
        -구축 : 게시물 쓰기의 게시물 출력 기능 구현

        타입 : 데이터 형태를 분류
            대분류 : 기본분류 (byte, short,int,long,float,double,char,boolean)8개
                   -참조타입([]배열,클래스,인터페이스,열거타입) 등등
            클래스 : 멤버변수(필드), 생성자, 메소드(멤버함수)로 구성된 새로운 타입 만들기
            객체 : 클래스 타입으로 생성된 메모리 공간
            변수 : 기본/ 참조 타입으로 생성된 메모리 공간



            1. main를 가지는 실행 클래스
            2. 설계 클래스
*/


package day22;

import java.util.Scanner;

public class BoardService3 {//실행클래스
    public static void main(String[] args) {

        //-입력 객체
        Scanner scan = new Scanner(System.in);
        Board[] boardList = new Board[100];
        //-고정길이- Board 객체 100개를 저장할 수 있는 배열

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

                for(int index = 0;index <= boardList.length-1;index++){
                    if(boardList[index]==null){
                        Board board = new Board();
                        board.content = content; board.writer = writer; board.pwd = pwd;
                        boardList[index] = board;
                        break;
                    }
                }
            } else if(choose == 2){
                for(int index = 0; index <= boardList.length-1 ; index++){
                    if(boardList[index]!=null){//만약에 index 게시물이 존재하면
                        System.out.printf("작성자 : %s, 내용 : %s%n ", boardList[index].writer, boardList[index].content);
                    }
                }

            }

        }

    }
}