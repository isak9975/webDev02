package day31.boardservice11mvc.view;

import day31.boardservice11mvc.controller.BoardController;
import day31.boardservice11mvc.model.BoardDto;

import java.util.ArrayList;
import java.util.Scanner;

public class BoardView {

    // -----------싱글톤------------
        //1. 지정한 클래스의 private static 객체를 생성한다.
     private static BoardView boardview = new BoardView();
        //2. 지정한 클래스는 외부로부터 객체 생성을 차단한다.
    private BoardView(){}
        //3. 내부의 객체를 외부로 부터 직접접근이 아닌 간접접근 할수 있도록
        //getter 함수를 만든다
    public static BoardView getInstance(){
        return boardview;
    }
    //

    Scanner scan = new Scanner(System.in);

   public void mainpage(){
        while(true){
                   System.out.print("1.게시물 등록 2. 게시물 출력 3.게시물 삭제 4.게시물 업데이트 : ");
            int choose = scan.nextInt();
            if(choose == 1){boardWrite();}
            else if(choose == 2){boardPrint();}
            else if(choose == 3){boardDelete();}
            else if(choose == 4){boardUpdate();}
        }//w
    }// m

    //view가 해야하는 역활 : 입력과 출력만 한다. (관례적인 약속)

    //1. 게시물 등록 함수
    void boardWrite(){

        System.out.println("게시물 내용 : "); String content = scan.next();
        System.out.println("게시물 작성자 : "); String wrtier = scan.next();
        System.out.println("게시물 비밀번호 : "); int pwd = scan.nextInt();
        //2. 입력받은 값을 컨트롤러에게 전달
        //3. 컨트롤러에게 전달후 결과를 받아 출력하기

        boolean result = BoardController.getInstance().boardWrite(content,wrtier,pwd);
    }
    //2.게시물 출력 함수
    void boardPrint(){
        //1. 컨트롤러에게 모든 게시물 정보를 받기
            //객채 왜 만듬? 다른 클래스의 메소드를 호출하기 위해서


        //2. 컨트롤러에게 받은 정보 출력하기
        ArrayList<BoardDto> result = BoardController.getInstance().boardPrint();

        for(int index = 0; index<=result.size()-1;index++){
            System.out.print("게시물 번호 : "+ "\"" + result.get(index).getNum() + "\"  ");
            System.out.print("게시물 : " + "\"" + result.get(index).getContent() + "\"  ");
            System.out.println("작성자 : " + "\"" +result.get(index).getWriter()+ "\"  ");
        }
   }
   /*
    게시물 1개 = Board 객체 1개
    게시물 여러개 = Board[] 배열 또는 컬렉션 프레임 워크 ArrayList<Board>
    */
    void boardDelete(){
        //(1) 삭제할 게시물 번호 입력 받기
        System.out.println("삭제할 게시물 번호를 입력해주세요 : ");
        int deleteNum = scan.nextInt();

        //(2) view는 실질적인 처리하는 곳ㅇ이 아니다(입출력)
            //-삭제는 매개변수 : 삭제할 번호, 삭제는 반환값
        boolean result = BoardController.getInstance().boardDelete(deleteNum);

        if(result){
            System.out.println("게시물 삭제 완료");
        }
        else{
            System.out.println("게시물 삭제 실패[존재하지 않는 게시물]");
        }
    }
    void boardUpdate(){
        //1. 수정할 게시물 번호 입력 받기
        System.out.println("수정할 게시물 번호를 입력해주세요 : ");
        int updateNum = scan.nextInt();

        System.out.println("수정할 내용을 입력 해주세요 : ");
        String updateContent = scan.next();

        boolean result = BoardController.getInstance().boardUpdate(updateNum,updateContent);
        if(result){
            System.out.println("게시물 수정 완료");
        }
        else{
            System.out.println("게시물 수정 실패");
        }
    }
}// c
