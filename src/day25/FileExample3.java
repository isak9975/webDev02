package day25;

import java.io.*;
import java.util.Scanner;

public class FileExample3 {
    public static void main(String[] args) {
        //생각해보기 :
        //1. 키보드로부터 입력 받은 문자열을 'day2'폴더내 test2.txt에 저장하시오
        //2. 'day25'폴더 내 test2.txt 에 저장된 (문자열)바이트 를 읽어 콘솔에 출력하시오

            //[1] 입력 객체
            Scanner scan = new Scanner(System.in);
            System.out.println("문자열을 입력하세요");
            //[2] 키보드로 입력 받기
            String text = scan.next();
        File file = new File("./src/day25/test2.txt");
            //[3] 파일 출력 객체 생성, 파일의 경로 지정
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("./src/day25/test2.txt");
            fileOutputStream.write(text.getBytes());
            System.out.println("[ 저장 성공 ]");

            //2.[1]파일 입력 객체 생성, 위세어 생성된 메모장을 읽어오기
            FileInputStream fileInputStream = new FileInputStream("./src/day25/test2.txt");
            //[2] 읽어온 바이트를 저장할 바이트 배열선언
            byte[] bytes = new byte[(int)file.length()];
                //(캐스팅) : 강제 타입 변환
                //배열내 [] 안에 들어가는 배열크기는 타입이 정수(int)만 가능하다
                //file.length의 반환값은 long타입이므로 int타입으로 변환시킴

            //현재 읽어올 파일의 용량을 몰라서 임의로 1000개로 한다.
            //[3] 준비된 바이트 배열에 읽어온 바이트를 저장한다.

            //[2-2] 읽어올 파일을 용량/ 바이트 개수를 확인 후 파일의 용량 만큼 배열 선언

            fileInputStream.read(bytes);
            //[4] 바이트를 문자열로 다시 변환하기
            System.out.println("[ 불러오기 성공 ]");
//            System.out.println(new String(bytes));
//            System.out.println(file.isFile());
//            System.out.println(file.getName());
//            System.out.println(file.length());

        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            System.out.println("[ 시스템 종료 ]");
        }

    }//end main
}//end calss
