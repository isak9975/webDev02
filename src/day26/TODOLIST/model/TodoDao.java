package day26.TODOLIST.model;

import day25.boardservice9mvc.model.BoardDto;

import java.io.*;
import java.util.ArrayList;

public class TodoDao {

        private static TodoDao boardDao = new TodoDao();
        private TodoDao(){
                File file = new File("./src/day25/boardservice9mvc/data.txt");
                if(file.exists()){
                        fileLoad();//-싱글톤(static)이 생성될때(프로그램이 실행될때)
                }
                else{
                        try {
                                file.createNewFile();
                        } catch (IOException e) {e.printStackTrace();}
                }


        }
        public static TodoDao getInstance(){

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
                fileSave();
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
                public void fileSave(){
                String outStr = "";

                for(int index = 0; index <= boardDB.size()-1;index++){// 리스트 객체내 0번 인텍스부터 마지막 인덱스까지
                        BoardDto boardDto = boardDB.get(index);//3.index 번째 의 게시물
                        //4.[객체내 필드 구분]index번째의 게시물객체내 필드값을 csc형식으로 변환
                        outStr += boardDto.getContent() + "," + boardDto.getWriter() + "," + boardDto.getPwd();
                        //+= 복합대입연산자 : 오른쪽값을 왼쪽변수 값과 더한후에 결과를 왼쪽 변수에 대입한다.
                        outStr += "\n";//5.[ 객체 구분 ]
                }
//                        System.out.println(outStr); //확인용

                try {
                        FileOutputStream fileOutputStream = new FileOutputStream("./src/day25/boardservice9mvc/data.txt");
                        fileOutputStream.write(outStr.getBytes());
                        System.out.println("[ 파일 저장 성공 ]");
                }
                catch (FileNotFoundException e){e.printStackTrace();}
                catch (IOException e){e.printStackTrace();}
        }


                public void fileLoad () { //프로그램이 실행 되었을때 1번만 실행되면 됨.
                        try {//Dao 객체(싱글톤) 생성될때 실행되게
                                FileInputStream inputStream = new FileInputStream("./src/day25/boardservice9mvc/data.txt");
                                File file = new File("./src/day25/boardservice9mvc/data.txt");
                                byte[] bytes = new byte[(int) file.length()];
                                //[3] 파일 입력 객체 이용한 파일 읽어서 바이트 배열 저장
                                inputStream.read(bytes);
                                String text  = new String(bytes);
//                                System.out.println(text);
                                //목표 : 파일로 가져온 문자열내 저장된 여러개 게시물들을 객체화 하고 게시물객체를 리스트에 담자
                                //[1] 객체 구분문자 (문자열 분해) : "문자열".split("기준문자") : 문자열내 기준문자 기준으로 분해 후 배열로 반환
                                        //inStr.split("\n") -> ["안녕,하세요","그래,안녕"]
                                String[] objStr = text.split("\n");
                                //[2]객체 내 필드 구분 문자(,)
                                for(int i =0;i< objStr.length;i++){
                                        String obj = objStr[i];//[3] 1개의 객체 필드 값을 가져오기
                                        //[4] 문자열로 된 필드 값을 객체로 변환하기
                                        String[] field = obj.split(",");
                                        String content = field[0];
                                        String writer =  field[1];
                                                int pwd = Integer.parseInt(field[2]); // String 타입을 int로 변환하는 방법0.Integer.parseInt("문자열")
                                        BoardDto boardDto = new BoardDto(content,writer,pwd);
                                        boardDB.add(boardDto);
                                }
                               }
                        catch (FileNotFoundException e){e.printStackTrace();}
                        catch (IOException e){e.printStackTrace();}


        }
}
