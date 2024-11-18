/*
    [JAVACONSOLE] TODOLIST 구축하기
        -조건1 : boardService9mvc  활용하여 MVC 패턴과 싱글톤 패턴과 파일처리 기능을 사용하시오.
        -조건2 : 할일 관리 기능은 할일등록과 할일 전체 출력 기능을 구현하시오
        -조건3 : 할일 객체의 필드는 할일내용, 할일마감날짜, 할일상태를 3개필드를 필수, 추가 기능

        (선택사항)
        +활용 조건1 : 할일 삭제 기능을 구현하시오
        +활용 조건2 : 할일 상태 수정 기능을 구현하시오. 완료 -->  미완료, 미완료 -->완료
*/

package day26.TODOLIST;

import day26.TODOLIST.view.TodoView;

public class AppStart {
    public static void main(String[] args) {

    TodoView.getInstance().mainpage();

    }
}
