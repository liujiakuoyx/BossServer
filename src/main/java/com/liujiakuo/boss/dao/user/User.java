package com.liujiakuo.boss.dao.user;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User{
    /**
     * id
     */
    @Id
    @GeneratedValue
    @Column(name = "uid")
    private Long ID;

    /**
     * 头像
     */
    @Column(name = "user_head")
    private String headUrl;

    /**
     * user类型
     */
    @Column(name = "user_type")
    private int type;

    /**
     * user通行证（账号）
     */
    @Column(name = "user_key")
    private String key;

    /**
     * user密码
     */
    @Column(name = "user_pass")
    private String pass;

    /**
     * user昵称
     */
    @Column(name = "user_nick")
    private String nick;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }
}
