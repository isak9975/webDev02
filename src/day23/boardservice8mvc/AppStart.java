package day23.boardservice8mvc;

import day23.boardservice8mvc.view.BoardView;

public class AppStart {
    public static void main(String[] args) {
        //메인 뷰 요청
        //- 다른 클래스의 존재하는 함수를 호출하는 방법
        //--객체를 생성한 ㅎ 객체명.메소드명()
        //싱글톤을 사용하기 전
            //BoardView view = new BoardView();
            //view.mainpage();

    //싱글톤을 사용했을때
    BoardView.getInstance().mainpage();
    }
}
