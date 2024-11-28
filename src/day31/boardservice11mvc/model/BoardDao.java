package day31.boardservice11mvc.model;

import java.sql.*;
import java.util.ArrayList;

public class BoardDao {
        private Connection connection; //연동된 결과의 연동 객체를 조작할 인터페이스
        private static BoardDao boardDao = new BoardDao();
        // 생성자에서 DB 연동 코드 작성
        private BoardDao(){
                try{
                        //[1] 외부라이브(JDBC) 폴더내 com폴더 -> mysql폴더 -> cj폴더 -> jdbc폴더 -> Driver 클래스 호출,
                        //forName() 특정한 클래스를 호출 하는데 사용되는 함수, 만일 클래스가 존재하지 않으면 어떠헥 해야 하는지 일반 예외에서
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        //[2] DB 연동 인터페이스 만들기 ,DriverManager.getConnection("MYSQLSERVER_URL/DB명" , "계정명" , "비밀번호");
                        //DriverManager.getConnection() : DB SERVER 와 연동을 성공 했을때 연동된 결과의 객체를 반환
                        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb1125" ,
                                "root" , "1234");
                        //[3] 확인
                        System.out.println("[3] DB 연동 성공");
                        //연동에 실패하는 이유 : 1. 프로젝트에 jbc 라이브러리 등록 안했다. 2.DB 연동 url 경로
                        }
                catch(ClassNotFoundException e){System.out.println("[3] 연동실패");e.printStackTrace();}
                //실패이유 :
                //1.프로젝트내 JDBC 라이브러리 등록 2.오타 체크 3. MYSQL 워크벤치에서 DB 존재 체크
                catch(SQLException e){System.out.println("[3] 연동실패");e.printStackTrace();}
        }
        public static BoardDao getInstance(){
                return boardDao;
        }


        public boolean boardWrite(BoardDto boardDto){
                //1. SQL 작성 = SQL 그대로 작성 하되 데이터가 들어가는 자리는 ?로 작성
                String sql = "insert into board(content,writer,pwd)values(?,?,?)";
                //2. 작성한  SQL 을 DB 연동객체의 기재한다. prepare: 준비한다, Statement : 기재한다, => 기재한다.
                try {
                        PreparedStatement ps = connection.prepareStatement(sql);
                //3. 기재된 SQL 의 매개 변수(?)에 값을 대입한다.
                        //ps.setInt(?순서번호,대입할데이터) = ?에 대입할 데이터가 int 타입일 때 사용
                        //ps.setString(?순서번호, 대입할테이터) = ?에 대입할 데이터가 String 타입일때 사용
                        ps.setString(1, boardDto.getContent()); // 1.SQL 내 첫번째 ? 뜻한다. ==> 첫번째 ? 입력받은 게시물 내용을 대입한다
                        ps.setString(2, boardDto.getWriter()); // 2.SQL 내 첫번째 ? 뜻한다. ==> 두번째 ? 입력받은 게시물 내용을 대입한다
                        ps.setInt(3, boardDto.getPwd()); // 3.SQL 내 첫번째 ? 뜻한다. ==> 세번째 ? 입력받은 게시물 내용을 대입한다
                //4. 기재된 SQL 을 실행한다. execute : 실행한다, Update : 최신화 한다. ==> SQL 실행후 최신화 한다.
                        ps.executeUpdate();
                }
                catch (SQLException e){e.printStackTrace();return false;}
                return true;
        }
        public ArrayList<BoardDto> boardPrint(){
                //1.SQL 작성
                String sql = "select * from board ";
                //2.SQL 기재
                ArrayList<BoardDto> list = new ArrayList<>();
                         try {
                                PreparedStatement ps = connection.prepareStatement(sql);
                                //3.SQL 조작
                                //4.SQL 실행, executeQuery() : SQL 실행 결과 조회된 SQL 결과 조작하는 resultSet 객체 반환
                                ResultSet rs = ps.executeQuery(sql);
                                //5.SQL 결과
                                 //객체화 해서 저장할 리스트 객체 생성
                                while(rs.next()){//while(조건){} : 반복문, rs.next() : 조회 결과에서 다음 레코드 이동함수
                                                //만약에 레코드가 3개 존재하면 rs.next() 3번 실행 된다.
                                                //[해석] 조회 결과 첫번째 레코드 부터 마지막 레코드 까지 하나씩 레코드 이동.
                                        //6. 레코드를 읽어서 각 필드별 데이터 호출, rs.getXXX("필드명") : 지정한 필드명의 값 타입에 맡게 값 변환
                                        int num = rs.getInt("num"); // 현재 조회중인 레코드의 게시물번호(num)필드 값 호출
                                        String content = rs.getString("content"); // 현재 조회중인 레코드의 게시물번호(content)필드 값 호출
                                        String wrtier = rs.getString("writer"); // 현재 조회중인 레코드의 게시물번호(writer)필드 값 호출
                                        int pwd = rs.getInt("pwd");// 현재 조회중인 레코드의 게시물번호(pwd)필드 값 호출
                                        //7. 각 레코드의 호출된 필드값들을 객체화 --> DTO 생성
                                        BoardDto boardDto = new BoardDto(num,content,wrtier);
                                        //8. 1개 레코드를 DTO 객체로 변환도니 DTO를 리스트에 저장
                                        list.add(boardDto);
                                        }

                                 rs.close();
                               }
                catch(SQLException e){e.printStackTrace();}
                return list;

                        }

public boolean boardDelete(int deleteNum){
        //1. SQL 작성
                String sql = "delete from board where num = ?;";
        try {
                PreparedStatement ps = connection.prepareStatement(sql);
                //2. SQL 기재
                ps.setInt(1,deleteNum);
                //3. 기재된 SQL 조작
                int result = ps.executeUpdate(); //delete 실행 수 레코드 개수를 반환
                if(result==1){return true;}
        }
        catch(SQLException e){e.printStackTrace();}
        //4. SQL 조작
        //5. 완료
        return false;

}
public boolean boardUpdate(int updateNum, String updateContent){
                String sql = "update board set content = ? where num =?;";
                try {
                        PreparedStatement ps = connection.prepareStatement(sql);
                        ps.setInt(2, updateNum);
                        ps.setString(1, updateContent);
                        int result = ps.executeUpdate();
                        if (result == 1) {
                                return true;
                        }
                }
                catch(SQLException e){e.printStackTrace();}
                return false;
}
}