package day24.MemberServiceMvc.view;

import day24.MemberServiceMvc.conrtroller.MemberController;
import day24.MemberServiceMvc.model.MemberDao;
import day24.MemberServiceMvc.model.MemberDto;

import java.util.Scanner;

public class MemberView {
    private static MemberView memberView = new MemberView();
    private MemberView(){}
    public static MemberView getInstance(){
        return memberView;
    }
    Scanner scan = new Scanner(System.in);

    public void mainpage(){
    while(true){
        System.out.print("1.회원가입 2.로그인 :  ");
        int choose = scan.nextInt();
        if(choose == 1){ //회원가입 진행
            memberSign();
        }
        else if(choose == 2){ //로그인 진행
            memberPrint();
        }
    }
    }
    void memberSign(){
        System.out.println("회원가입 해주세요");
        System.out.println("아이디 입력 : "); String name = scan.next();
        System.out.println("비밀번호 입력 : "); int pwd = scan.nextInt();

        boolean result = MemberController.getInstance().memberSign(name,pwd);

        System.out.println("회원가입이 완료 되었습니다");
    }
    void memberPrint(){
        System.out.println("로그인 해주세요");
        System.out.println("아이디 입력 : "); String name = scan.next();
        System.out.println("비밀번호 입력 : "); int pwd = scan.nextInt();

        MemberDto memberDto = new MemberDto(name,pwd);


        //아이디, 비밀번호가 같은지 판별
        if(MemberDao.getInstance().memberPrintr().contains(memberDto)){
            System.out.println("로그인 성공");
        }
        else{
//            System.out.println(memberDto);
//            boolean result1 = MemberDao.getInstance().memberPrintr().equals(memberDto);
//            System.out.println(result1);//false
//            boolean result = MemberDao.getInstance().memberPrintr().contains(memberDto);
//            System.out.println(result);//flase
//            System.out.println(MemberDao.getInstance().memberPrintr()); //멤버 함수 sign , 123
//            System.out.println(MemberDao.getInstance().equals(MemberDao.getInstance().memberPrintr()));// false
            System.out.println("아이디 또는 비밀번호가 다릅니다.");
            System.out.println("처음부터 다시 진행 해주세요");
        }
    }

}
