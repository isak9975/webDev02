package day26.TODOLIST.model;

public class TodoDto {

        //-클래스 구성 멤버
        //1.멤버 변수(필드)
        private String content;
        private String date;
        private boolean ;

        public TodoDto(){}
        //2-2 매개ㅣ변수 1개 존재하는 생성자
        public TodoDto(String content){this.content=content;}
        //2-3 매개ㅣ변수 2개 존재하는 생성자
        public TodoDto(String content, String writer){this.content=content;this.writer=writer;}
        //2-4 매개ㅣ변수 3개 존재하는 생성자
       public TodoDto(String content, String writer, int pwd){this.content=content;this.writer=writer;this.pwd=pwd;}

        //3. 메소드(멤버함수)
        //-getter 함수 : private 선언된 필드를 public으로 함수로 외부 클래스부터 간접전근 허용한다.
        public String getContent() {
            return content;
        }
        //Setter 힘스 : private 선언된 필드를 public 함수로 외부 클래스부터 간접접근허용한다.
        public void setContent(String content) {
            this.content = content;
        }

        public String getWriter() {
            return writer;
        }

        public void setWriter(String writer) {
            this.writer = writer;
        }

        public int getPwd() {
            return pwd;
        }

        public void setPwd(int pwd) {
            this.pwd = pwd;
        }


        @Override
        public String toString() {
            return "Board{" +
                    "content='" + content + '\'' +
                    ", writer='" + writer + '\'' +
                    ", pwd=" + pwd +
                    '}';
        }
    }



