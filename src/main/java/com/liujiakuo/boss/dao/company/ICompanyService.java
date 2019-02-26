package com.liujiakuo.boss.dao.company;

import com.liujiakuo.boss.bean.CompanyInfo;

import java.util.List;

public interface ICompanyService {
    List<Company> findAll();

    Company insert(Company company);

    Company update(Company company);

    void delete(Company company);

    List<Company> findCompanyByName(String name);

    /**
     * 分页加载数据
     */
    List<Company> getCompanyList(int page);

    /**
     * 获取公司信息
     */
    CompanyInfo findById(String id);
}
