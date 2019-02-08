package com.liujiakuo.boss.dao.job;

import com.liujiakuo.boss.dao.company.Company;
import jdk.nashorn.internal.scripts.JO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImp implements IJobService {

    @Autowired
    IJobRepository repository;
    private final int PAGE_SIZE = 10;

    @Override
    public List<Job> findAll() {
        return repository.findAll();
    }

    @Override
    public Job insertUser(Job job) {
        return repository.save(job);
    }

    @Override
    public void deleteJob(Job job) {
        repository.delete(job);
    }

    @Override
    public Job updateJob(Job job) {
        return repository.save(job);
    }

    @Override
    public List<Job> findByName(String name) {
        return repository.findLikeName(name);
    }

    @Override
    public List<Job> getJobList(int page) {
        Pageable pageable = PageRequest.of(page, PAGE_SIZE);
        Page<Job> allPage = repository.findAll(pageable);
        return allPage.getContent();
    }
}
