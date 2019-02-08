package com.liujiakuo.boss.dao.job;


import javax.naming.Name;
import javax.persistence.*;

@Entity
@Table(name = "job")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "j_id")
    private Long ID;

    /**
     * 工作名称
     */
    @Column(name = "j_name")
    private String name;

    /**
     * 地点
     */
    @Column(name = "j_location")
    private String location;

    /**
     * 学历要求
     * 学历不限、大专、本科、研究生、博士
     */
    @Column(name = "j_education")
    private String education;

    /**
     * 工龄
     */
    @Column(name = "j_working_years")
    private String workYears;

    /**
     * 薪资
     */
    @Column(name = "j_salary")
    private String salary;

    /**
     * 职位详情
     */
    @Column(name = "j_details")
    private String details;

    /**
     * 发布者
     */
    @Column(name = "j_post_user")
    private String userKey;

    /**
     * 所属公司
     */
    @Column(name = "j_company_id")
    private Long companyId;

    public String getUserKey() {
        return userKey;
    }

    public void setUserKey(String userKey) {
        this.userKey = userKey;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getWorkYears() {
        return workYears;
    }

    public void setWorkYears(String workYears) {
        this.workYears = workYears;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
