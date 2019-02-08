package com.liujiakuo.boss.dao.company;

import com.liujiakuo.boss.utils.DataUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Book;

import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyService implements ICompanyService {

    @Autowired
    ICompanyRepository repository;
    private final int PAGE_SIZE = 10;

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

    @Override
    public List<Company> getCompanyList(int page) {
        Pageable pageable = PageRequest.of(page, PAGE_SIZE);
        Page<Company> allPage = repository.findAll(pageable);
        return allPage.getContent();
    }
}
