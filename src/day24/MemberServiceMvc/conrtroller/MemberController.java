package day24.MemberServiceMvc.conrtroller;

import day24.MemberServiceMvc.model.MemberDao;
import day24.MemberServiceMvc.model.MemberDto;

import java.util.ArrayList;

public class MemberController {
    private static MemberController memberController = new MemberController();

    private MemberController() {}

        public static MemberController getInstance() {
            return memberController;
        }

    public boolean memberSign(String name,
                              int pwd){
        MemberDto memberDto = new MemberDto(name,pwd);
        return MemberDao.getInstance().memberSign(memberDto);
    }

    public ArrayList<MemberDto> memberPrint(){
        ArrayList<MemberDto> result = MemberDao.getInstance().memberPrintr();;
        return result;
    }

}
