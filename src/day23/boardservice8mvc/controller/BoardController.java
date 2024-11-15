package day23.boardservice8mvc.controller;

import day23.boardservice8mvc.model.BoardDao;
import day23.boardservice8mvc.model.BoardDto;

public class BoardController {

    //1. 게시물 등록 제어 함수
    public boolean boardWrite(String content,
                              String writer,
                              int pwd){
        BoardDto boardDto = new BoardDto(content,writer,pwd);
        //3. 입력받은 객체를 저장하기 위해 Dto전달하고 결과를 응답 받기
        BoardDao   boardDao = new BoardDao();
        return boardDao.boardWrite(boardDto);
    }
    //2. 게시물 출력 제어 함수
    public void boardPrint(){

    }
}
