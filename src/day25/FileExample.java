package day25;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class FileExample {
    public static void main(String[] args) {

        //1. 파일 출력(쓰기)
        //- 자바에서 사용되는 데이터를 자바외부 (c:/java)에 메모장으로 저장
        try {
            //예외가 발생 할것 같은 코드 try{} 안에서 작성한다
//            FileOutputStream fileOutput = new FileOutputStream("c:/java/test1.txt");
            FileOutputStream fileOutput = new FileOutputStream("./src/day25/test1.txt");
            fileOutput.write("Hello java".getBytes());
            //fileoutput[객체].wirte[메서드](인자값1);
        }
        catch(FileNotFoundException e){//예외가 발생했을때 실행될 코드 작성
            e.printStackTrace();;
        }
        catch(Exception e){ //[ 모든 예외 ]가 발생 했을시 실행되는 코드 작성한다.
            e.printStackTrace();
        }
        finally {
            //예외가 있던 없던 실행되는 코드를 작성한다.
        }
    }
}
