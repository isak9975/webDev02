package day24.MemberServiceMvc.model;

import java.util.ArrayList;

public class MemberDao {
    private static MemberDao memberDao = new MemberDao();
    private MemberDao(){}
    public static MemberDao getInstance(){
            return memberDao;
    }

    ArrayList<MemberDto> memberDB = new ArrayList<>();

    public boolean memberSign(MemberDto  memberDto){
        memberDB.add(memberDto);
        return true;
    }

    public ArrayList<MemberDto> memberPrintr(){
        return memberDB;
    }
}
