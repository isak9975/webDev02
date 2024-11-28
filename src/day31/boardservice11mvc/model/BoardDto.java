package day31.boardservice11mvc.model;

public class BoardDto {

        //-클래스 구성 멤버
        //1.멤버 변수(필드)
        private int num;
        private String content;
        private String writer;
        private int pwd;


        //[2]생성자 , 객체 생성시 초기화를 담당하는 메소드 로써
        //DTO 주로 생성시 개발자(본인) 초기화할 필드로 생성자를 구성ㅎ나다
        public BoardDto(){}
        //2-2 매개ㅣ변수 1개 존재하는 생성자
        public BoardDto(String content){this.content=content;}
        //2-3 매개ㅣ변수 2개 존재하는 생성자
        public BoardDto(String content, String writer){this.content=content;this.writer=writer;}
        //2-4 매개ㅣ변수 3개 존재하는 생성자
       public BoardDto(String content, String writer,int pwd){this.content=content;this.writer=writer;this.pwd=pwd;}

       public BoardDto(int num,String content,String writer,int pwd){this.num = num;this.content=content;this.writer=writer;this.pwd=pwd;}

    public BoardDto(int num, String content, String writer) {
        this.num = num;
        this.content = content;
        this.writer = writer;
    }

    public BoardDto(int num, String content) {
        this.num = num;
        this.content = content;
    }

    //3. 메소드(멤버함수)] DTO = 실질적인 기능 역활X ,단순 이동 객체 이므로
        //DTO 주로 GETTER, SETTER, ToString 역활이 크다
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

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
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



