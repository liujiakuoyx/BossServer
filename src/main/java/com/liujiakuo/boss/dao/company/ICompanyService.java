package com.liujiakuo.boss.dao.company;

import java.util.List;

public interface ICompanyService {
    List<Company> findAll();

    Company insert(Company company);

    Company update(Company company);

    void delete(Company company);

    List<Company> findCompanyByName(String name);
}
