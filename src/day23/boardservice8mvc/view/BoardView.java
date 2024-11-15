package day23.boardservice8mvc.view;

import day23.boardservice8mvc.controller.BoardController;

import java.sql.SQLOutput;
import java.util.Scanner;

public class BoardView {

    Scanner scan = new Scanner(System.in);

   public void mainpage(){
        while(true){
                   System.out.print("1.게시물 등록 2. 게시물 출력 : ");
            int choose = scan.nextInt();
            if(choose == 1){boardWrite();}
            else if(choose == 2){boardPrint();}
        }//w
    }// m

    //view가 해야하는 역활 : 입력과 출력만 한다. (관례적인 약속)

    //1. 게시물 등록 함수
    void boardWrite(){
        scan.next();
        System.out.println("게시물 내용 : "); String content = scan.nextLine();
        System.out.println("게시물 작성자 : "); String wrtier = scan.next();
        System.out.println("게시물 비밀번호 : "); int pwd = scan.nextInt();
        //2. 입력받은 값을 컨트롤러에게 전달
        //3. 컨트롤러에게 전달후 결과를 받아 출력하기
        BoardController boardController = new BoardController();
        boolean result = boardController.boardWrite(content,wrtier,pwd);
    }
    //2.게시물 출력 함수
    void boardPrint(){
        //1. 컨트롤러에게 모든 게시물 정보를 받기
        //2. 컨트롤러에게 받은 정보 출력하기
    }
}// c
