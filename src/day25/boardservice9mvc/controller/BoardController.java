package day25.boardservice9mvc.controller;

import day25.boardservice9mvc.model.BoardDao;
import day25.boardservice9mvc.model.BoardDto;

import java.util.ArrayList;

public class BoardController {

    private static BoardController boardController = new BoardController();

    private BoardController(){};

    public static BoardController getInstance() {
        return boardController;
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
}
