package day24.MemberServiceMvc.model;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if(o instanceof MemberDao){
            MemberDao temp = (MemberDao)o;

        }
        return true;
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        MemberDto memberDto = (MemberDto) o;
//        return pwd == memberDto.pwd && Objects.equals(name, memberDto.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, pwd);
    }
}
