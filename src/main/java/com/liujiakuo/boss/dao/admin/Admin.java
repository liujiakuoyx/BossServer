package com.liujiakuo.boss.dao.admin;

import javax.persistence.*;

@Entity
@Table(name = "boss_admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id")
    private Long ID;

    @Column(name = "admin_key")
    private String key;

    @Column(name = "admin_name")
    private String name;

    @Column(name = "admin_pass_word")
    private String pass;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
