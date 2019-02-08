package com.liujiakuo.boss.dao.company;

import javax.persistence.*;

@Entity
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue
    @Column(name = "c_id")
    private Long ID;

    /**
     * 公司名称
     */
    @Column(name = "c_name", nullable = false)
    private String name;

    /**
     * 头像
     */
    @Column(name = "c_head_url")
    private String headUrl;

    /**
     * 公司信息
     */
    @Column(name = "c_info", nullable = false)
    private String info;

    /**
     * 融资阶段
     * 按等级依次为 不需要融资、未融资、天使轮、A、B、C、D及以上、已上市。
     */
    @Column(name = "c_financing_stage", nullable = false)
    private String stage;

    /**
     * 注册资金
     */
    @Column(name = "c_registered_capital")
    private String capital;

    /**
     * 注册时间
     */
    @Column(name = "c_registration_time")
    private String registrationTime;

    /**
     * 法人
     */
    @Column(name = "c_legal_person")
    private String person;

    /**
     * 公司官网
     */
    @Column(name = "c_cfficial_website")
    private String website;

    /**
     * 员工人数
     * 0-20、20-99、100-499、500-1000、1000-9999、10000以上
     */
    @Column(name = "c_number_of_employees")
    private String number;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getRegistrationTime() {
        return registrationTime;
    }

    public void setRegistrationTime(String registrationTime) {
        this.registrationTime = registrationTime;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
