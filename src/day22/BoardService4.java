/*
    BoardService4
        -BoardService3 모든 코드를 복사후 진행
        -기존코드 : 고정길이인 Board[] boardList = new Board[100];
        -수정조건:
            고정길이가 아닌 가변길이 형식으로 수정하여 100개 아닌
            무한개 저장 가능한 가변길이 배열 만들기


            *이유:가변길이의 여러개 데이터를 관리할때는
                    -컬레션프레임워크(ArrayList) = 실무
                    -가변배열 = 시험/ 코테/ C언어
*/


package day22;

import java.util.Scanner;

public class BoardService4 {
    public static void main(String[] args) {
        //-입력 객체
        Scanner scan = new Scanner(System.in);
        Board[] boardList = null;
        //-현재
        int count = 0;

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

                count++;//게시물수 1증가

                Board[] newBoardList = new Board[count]; //새로운 배열 생성
                //기존 배열내 게시물들을 새로운 배열에 이동하기 / 배열 복사
                if(count != 1) { //만약에 기존 배열내 게시물이 존재하지 않으면
                    for(int index=0; index<=boardList.length-1;index++){
                        newBoardList[index] = boardList[index];
                    }
                }
                newBoardList[count-1] = board;
                ///새로운 배열을 기존 배열에 대입한다
                boardList = newBoardList;

                //새로운 배열내 마지막 인덱스(배열명.length-1)에 입력 받은 게시물 객체 등록


                //마지막 인덱스에 새로운 객체 등록.
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
/*
<1>
public Class BoardService4{
    public static void main(String[] args){
        Scanner scan= new Scanner(System.in);
        Board[] boardList =  null;
        int count=0;
        while(true){
            System.out.println("1.글쓰기 2. 글출력 : ");
            int choose = scan.nextInt();
            if(choose = 1){
                System.out.print("내용 : "); String content = scan,next();
                System.out.print("작성자 : "); String writer = scan.next();
                System.out.print("비밀번호 : "); int pwd = scan,nextInt();

                Board board = new Board();
                board.content = content; board.writer = writer; board.pwd = pwd;

                count++;

                Board[] newBoardList = new Board[count];
                if(count != 1){
                    for(int index = 0; index <= boardList.length-1; index++){
                        newBoardList[index] = boardList[index];
                    }
                }
                newBoardList[count-1] = board;
                boardList = newBoardList;
            }
            else if(choose == 2){
                for(int index = 0;  index <= boardList.length-1;index++){
                    if(boardList[index] != null){
                        System.out.prinf("작성자 : %s, 내용: %s%n".boardList[index].writer,boardList[index].content);
                    }
                }
            }
        }

*/