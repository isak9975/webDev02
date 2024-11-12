/*
    BoardService2
        - 제목과 작성자로 구성된 게시물을 최대 100개 까지 저장하는 서비스 구축
        - 제약 : main 1개 와 반복문, 배열을 최대 2개까지 사용해서
        - 구축 : 게시물 글쓰기 와 글 출력 기능 구현
 */

package day21;

import java.util.Scanner;

public class BoardService2 {
    public static void main(String[] args) {

        //BoardService1 에서 변수를 사용했는데 배열 변수를 사용하는 이유
            //-여러개의 변수에 있는 데이터를 배열로 사용하면 관리가 편하다
        //배열이란? 여러개의 동일한 타입의 데이터들을 *하나의 변수*에 저장할수 있는 타입
        //인덱스란? 배열내 저장된 데이터들의 저장 순서 번호
        Scanner scan = new Scanner(System.in);

        String[] content = new String[100]; // 배열선언 방법 : 타입[] 변수명 = new 타입[개수];
        String[] writer = new String[100]; // String 데이터 100개를 저장할수 있는 배열 선언;


        while(true) {//무한루프
            System.out.println("----------------------------");
            System.out.print("1. 게시물쓰기 2.게시물 출력 선택 :");

            int choose = scan.nextInt();

            //if : 다중 if는 다중 조건의 다중 결과를 충족 할 수 있다.
            //if ~ elseif :는 다중 조건의 무조건 1개의 결과를 충족한다


            if (choose == 1) {//만약에 입력한 값이 1이면 '게시물 쓰기'구현 //게시물을 작성할 공간이 있는지 체크, 임의로 게시물이 존재하지 않는 뜻 Null 또는 ""
                //게시물 저장할 내용 입력 받기
                System.out.print("새로운 게시물 내용 : ");
                String contentsc = scan.next();
                System.out.print("새로운 게시물 작성자 : ");
                String writersc = scan.next();
//                System.out.print("게시물 인덱스 번호 : ");
//                int i  = scan.nextInt();
                //만약에 게시물이 비어 있으면, 게시물이 100이면 if 100개 검사?
                    //인덱스 0부터 마지막 인덱스 99까지


                boolean save = false; //스위치 변수 = 상태 저장하는 변수


                for(int index = 0;index<= content.length-1;index++){
                    if (content[index] == null) {//만약에 첫번째 게시물의 정보가 비어있으면
                        content[index] = contentsc;writer[index] = writersc;
                        save = true; // 만약에 저장 성공 했으면 save변수에 true 값으로 저장
                        break;//break 만약에 저장을 했으면 1개 저장해야 하므로 break 해서 반복문 종료
                    }// else if end

                }//for end
                //for 종료후에

                if(save ){System.out.println("게시물 쓰기 성공");}
                else{System.out.println("비어있는 자리가 없습니다");}



//                if (content[i] == null) {//만약에 첫번째 게시물의 정보가 비어있으면
//                    content[i] = contentsc;writer[i] = writersc;
//                }// else if end
//                else  { //만약에 두번째 게시물의 정보가 비어있으면
//                    System.out.println("게시물 쓰기 실패 : 빈 공간이 없습니다");
//                }// else if end


            }


            if (choose == 2) {//만약에 입력한 값이 2이면 '게시물 출력'구현
                for(int index = 0; index <= content.length-1 ; index++){
                    if(content[index]!=null){//만약에 index 게시물이 존재하면
                        System.out.printf("작성자 : %s, 내용 : %s%n ", writer[index], content[index]);
                    }
                }






//                int i=0;
//                if (content[i] != null) {//만약에 첫번째 게시물이 존재하면
//                    System.out.printf("작성자 : %s, 내용 : %s ", writer[i], content[i]);
//                }
//                if (content[i] != null) {//만약에 첫번째 게시물이 존재하면
//                    System.out.printf("작성자 : %s, 내용 : %s ", writer[i], content[i]);
//                }
//                if (content[i] != null) {//만약에 첫번째 게시물이 존재하면
//                    System.out.printf("작성자 : %s, 내용 : %s ", writer[i], content[i]);
//                }


            }
        }















    }
}
