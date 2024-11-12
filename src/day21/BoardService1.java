/*
    BoardService1
        - 제목과 작성자로 구성된 게시물을 최대 3개 까지 저장하는 서비스 구축
        - 제약 : main 1개 와 변수 6개와 반복문 사용
        - 구축 : 게시물 글쓰기 와 글 출력 기능 구현
 */
//배열을 사용해서, 컬렉턴프레임워크을 사용해서,클래스만을 사용해서


package day21;

import java.util.Scanner;

public class BoardService1 {
    public static void main(String[] args) {//main start //번역된 코드들을 실행하는 기능(main스래드)

        // - 저장소 설계, 계시물1개당 내용과 작성자(내용2개), 게시물3개면 내용 6개
            //변수란? 하나의 데이터/주소값를 저장하는 공간/메모리
            //타입이란? 변수의 저장도리 테이터/주소의 타입, 데이터 분류, 기본타입 VS 참조타입

        String content1 = null;        String writer1 = null; //첫번째 게시물
        String content2 = null;        String writer2 = null; //두번째 게시물
        String content3 = null;        String writer3 = null; //세번째 게시물

        Scanner scan = new Scanner(System.in);

        while(true) {//무한루프
            System.out.println("----------------------------");
            System.out.print("1. 게시물쓰기 2.게시물 출력 선택 :");

            int choose = scan.nextInt();

            //if : 다중 if는 다중 조건의 다중 결과를 충족 할 수 있다.
            //if ~ elseif :는 다중 조건의 무조건 1개의 결과를 충족한다

            if (choose == 1) {//만약에 입력한 값이 1이면 '게시물 쓰기'구현 //게시물을 작성할 공간이 있는지 체크, 임의로 게시물이 존재하지 않는 뜻 Null 또는 ""
                //게시물 저장할 내용 입력 받기
                if (content1 != null & content2 != null & content3 != null) {
                    System.out.println("게시물 쓰기 실패 : 빈 공간이 없습니다");
                }

                System.out.print("새로운 게시물 내용 : ");
                String content = scan.next();
                System.out.print("새로운 게시물 작성자 : ");
                String writer = scan.next();
                if (content1 != null & content2 != null & content3 != null) {
                    System.out.println("게시물 쓰기 실패 : 빈 공간이 없습니다");
                }


                if (content1 == null) {//만약에 첫번째 게시물의 정보가 비어있으면
                    content1 = content;
                    writer1 = writer;
                }// else if end
                else if (content2 == null) { //만약에 두번째 게시물의 정보가 비어있으면
                    content2 = content;
                    writer2 = writer;
                }// else if end
                else if (content3 == null) { //만약에 두번째 게시물의 정보가 비어있으면
                    content3 = content;
                    writer3 = writer;
                }// else if end
                else {
                    System.out.println("게시물 쓰기 실패 : 빈 공간이 없습니다");
                }//else end

            }


            if (choose == 2) {//만약에 입력한 값이 2이면 '게시물 출력'구현

                if (content1 != null) {//만약에 첫번째 게시물이 존재하면
                    System.out.printf("작성자 : %s, 내용 : %s ", writer1, content1);
                }
                if (content2 != null) {//만약에 첫번째 게시물이 존재하면
                    System.out.printf("작성자 : %s, 내용 : %s ", writer2, content2);
                }
                if (content3 != null) {//만약에 첫번째 게시물이 존재하면
                    System.out.printf("작성자 : %s, 내용 : %s ", writer3, content3);
                }


            }
        }



    }// main end
}//class end
