package day38.boardservice12mvc.controller;

import day38.boardservice12mvc.model.BoardDao;
import day38.boardservice12mvc.model.BoardDto;
import day38.boardservice12mvc.view.BoardView;

import java.util.ArrayList;

import static day38.boardservice12mvc.view.BoardView.gn;

public class BoardController {
    static boolean gn;
    private static BoardController boardController = new BoardController();

    private BoardController(){};

    public static BoardController getInstance() {
        return boardController;
    }

    public static boolean getGn() {
        return gn;
    }

    public static void setGn(boolean gn) {
        BoardController.gn = gn;
    }

    //1. 게시물 등록 제어 함수
    public boolean boardWrite(String content,
                              String writer,
                              int pwd){
        BoardDto boardDto = new BoardDto(content,writer,pwd);
        //3. 입력받은 객체를 저장하기 위해 Dto전달하고 결과를 응답 받기
        return BoardDao.getInstance().boardWrite(boardDto);
    }
    //2. 게시물 출력 제어 함수
    public ArrayList<BoardDto> boardPrint(){
        //void : 메서드 호출시 반환값 없음을 나타냄
        //void 대신 여러개 게시물 반환 받고 싶어
        //void -> ArrayList<Board>
        // dao에게 게시물 전체 출력 함수를 호출해서 결과를 받는다
        //

            //BoardDao의 메소드를 호출하기 위해 객체 호출
        //2.메서드 호출 Dao에게 메소드를 호출하고 전부 받기.
        ArrayList<BoardDto> result = BoardDao.getInstance().boardPrint();
        //3. Dao에게 응답ㅎ받은 결과를 view 응답하기
        return result; // -return
    }// e end

    public boolean boardDelete(int deleteNum){
        //1. view 에게 매개변수의 값 받는다
        //2. 유효성(원하는 데이터인지)검사
        //3. DAO 에게 삭제할 번호를 전달하여 DB 처리 요청 결과를 받는다
        boolean result = BoardDao.getInstance().boardDelete(deleteNum);
        //4. Dao 에게 받은 결과를 view 전달한다(controller중계)
        return result;
    }
    public boolean boardUpdate(int updateNum, String updateContent){
        boolean result = BoardDao.getInstance().boardUpdate(updateNum,updateContent);
        return result;
    }

    public boolean boardLogin(String id,int pwd){
        //위의 boardDelete 참고
        //1. 로그인 시 view에서 아이디와 비밀번호 받아오기(String id,int pwd)
        //2. Dao에게 아이디와 비밀번호 전달하여 DB 처리 요청(자료가 있는지 확인) 결과를 받음
       boolean result = BoardDao.getInstance().boardLogin(id,pwd);

        return result;
    }
}
