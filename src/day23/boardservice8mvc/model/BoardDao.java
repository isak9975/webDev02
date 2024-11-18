package day23.boardservice8mvc.model;

import java.util.ArrayList;

public class BoardDao {

        private static BoardDao boardDao = new BoardDao();
        private BoardDao(){}
        public static BoardDao getInstance(){
                return boardDao;
        }

        ArrayList<BoardDto> boardDB = new ArrayList<>();
        //ArrayList<BoardDto>형식의 boardDB라는 데이터베이스를 만듬

        //1. 게시물 등록 접근 함수
        public boolean boardWrite(BoardDto boardDto){
        //접근자, 반환값형태, 메서드명(매개변수)
                /*
                        1. 다른곳에서 boardWrite를 사용하여 값을 보내면(boardDto 들어옴)
                        2. 값을 boardDB에 저장(boardDto 저장)
                        3. 들어온곳에 true라고 반환값을 반환
                */
                boardDB.add(boardDto);
                return true;//
        }
        //2. 게시물 출력 접근 함수
        public ArrayList<BoardDto> boardPrint(){
        //접근자, 반환값형태(ArrayList<BoardDto>), 메서드명
                /*
                        1. 다른곳에서 메서드가 호출되면
                        2. 데이터 베이스인 boardDB 전부 반환
                */
                return boardDB;
        }
}
