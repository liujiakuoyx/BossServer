package com.liujiakuo.boss.dao.company;

import com.liujiakuo.boss.utils.DataUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyService implements ICompanyService {
    @Autowired
    ICompanyRepository repository;

    @Override
    public List<Company> findAll() {
        return repository.findAll();
    }

    @Override
    public Company insert(Company company) {
        return repository.save(company);
    }

    @Override
    public Company update(Company company) {
        return repository.save(company);
    }

    @Override
    public void delete(Company company) {
        repository.delete(company);
    }

    @Override
    public List<Company> findCompanyByName(String name) {
        List<Company> companys = repository.findLikeName(name);
        if (DataUtils.isEmpty(companys)) {
            return new ArrayList<Company>();
        }
        return companys;
    }
}
