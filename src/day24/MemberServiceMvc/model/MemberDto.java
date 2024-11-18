package day24.MemberServiceMvc.model;

public class MemberDto {
    private String name;
    private int pwd;

    public MemberDto(String name,int pwd){this.name = name;this.pwd = pwd;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPwd() {
        return pwd;
    }

    public void setPwd(int pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "MemberDto{" +
                "name='" + name + '\'' +
                ", pwd=" + pwd +
                '}';
    }


}
