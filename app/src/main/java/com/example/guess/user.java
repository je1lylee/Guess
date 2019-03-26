package com.example.guess;

public class user {
    private  String userName;
    private String passWord;//明文存储传送，想起来了再想加密吧233333
    private float score;
    private String rank;
    private int loginFlag = -1;//定义-1为未登录或登录失败，1为登录成功

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public int getLoginFlag() {
        return loginFlag;
    }

    public void setLoginFlag(int loginFlag) {
        this.loginFlag = loginFlag;
    }
    //TODO 数据库操作在此调用database包中的方法进行。数据库操作返回然后反馈给FrontEnd
}
