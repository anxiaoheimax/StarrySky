package com.sky.model;
//用户
public class User {
    //用户id
    private int Uid;
    //用户名
    private String Uname;
    //用户密码
    private String Upassword;
    //用户头像
    private String img;
    //用户等级
    private int grade;

    public User() {
    }

    public User(int uid, String uname, String upassword, String img, int grade) {
        Uid = uid;
        Uname = uname;
        Upassword = upassword;
        this.img = img;
        this.grade = grade;
    }

    public User(String uname, String upassword, String img, int grade) {
        Uname = uname;
        Upassword = upassword;
        this.img = img;
        this.grade = grade;
    }

    public int getUid() {
        return Uid;
    }

    public void setUid(int uid) {
        Uid = uid;
    }

    public String getUname() {
        return Uname;
    }

    public void setUname(String uname) {
        Uname = uname;
    }

    public String getUpassword() {
        return Upassword;
    }

    public void setUpassword(String upassword) {
        Upassword = upassword;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "User{" +
                "Uid=" + Uid +
                ", Uname='" + Uname + '\'' +
                ", Upassword='" + Upassword + '\'' +
                ", img='" + img + '\'' +
                ", grade=" + grade +
                '}';
    }
}
