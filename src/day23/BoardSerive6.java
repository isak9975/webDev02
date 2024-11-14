/*
 * BoardService6
 */


package day23;

import java.util.ArrayList;
import java.util.Scanner;

public class BoardSerive6 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);//

        ArrayList<Board> boardList= new ArrayList<>();//컬렉션 프레임 워크를 사용한 Board형만 들어갈 수 있는 가변길이의 배열 만들기

        while (true) {
            System.out.println("1.글쓰기, 2.글출력 : ");
            int choose = scan.nextInt();
            if(choose ==1){
                System.out.print("내용 : ");  String content = scan.next();
                System.out.print("작성자 : "); String writer  = scan.next();
                System.out.print("비밀번호: "); int pwd = scan.nextInt();

                Board board = new Board(content,writer,pwd); //- 입력 받은 내용으로 게시물 객체 생성

                boardList.add(board);//생성된 객체의 값을 컬렉션 프레임 워크에 넣기 -순서상관없음

            } else if(choose == 2){
                for(int index = 0; index <= boardList.size()-1 ; index++){

                    System.out.printf("작성자 : %s, 내용 : %s%n ", boardList.get(index).getWriter(), boardList.get(index).getContent());

                }//boardList/*컬렉션 프레임워크에서*/.get(index)/*몇번째의 Borad객체선택*/.getWriter()/*Board 객체의 값 얻기*/
            }
        }
    }//main end
}//class end
