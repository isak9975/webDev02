package day25;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileExmaple2 {
    public static void main(String[] args) {
        //1.파일 읽기
        try {
            FileInputStream fileInputStream = new FileInputStream("./src/day25/test1.txt");
            byte[] bytes = new byte[10]; //"hello java" 문자열이 10바이트 이므로
            fileInputStream.read(bytes); // -> 파일을 바이트 단위로 읽어오는 함수
            System.out.println(new String(bytes));
        }
        catch (FileNotFoundException e){
            //만약에 파일의 경로가 존재하지 않으면 예외 발생후 실행코드 코드
            e.printStackTrace();
        }
        catch (IOException e){
            //만약에 읽어오는 과정에서 예외 발생 하면 실행되는 코드
           e.printStackTrace();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
            System.out.println("시스템 종료");
        }
    }
}
