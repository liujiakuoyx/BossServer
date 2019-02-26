package com.liujiakuo.boss.bean;

public class UserInfo {
    /**
     * 头像
     */
    private String headUrl;

    /**
     * user昵称
     */
    private String nick;

    /**
     * id
     */
    private String uid;

    /**
     * 职务
     */
    private String post;

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }
}
