package com.liujiakuo.boss.dao.job;

import com.liujiakuo.boss.bean.CompanyInfo;
import com.liujiakuo.boss.bean.PositionBean;
import com.liujiakuo.boss.bean.UserInfo;
import com.liujiakuo.boss.utils.DataUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<PositionBean> findByName(String name) {
        List<Job> jobList = repository.findLikeName(name);
        List<PositionBean> positionBeanList = new ArrayList<>();
        if (jobList != null) {
            for (Job job : jobList) {
                PositionBean bean = convertData(job);
                positionBeanList.add(bean);
            }
        }
        return positionBeanList;
    }

    @Override
    public List<PositionBean> getJobList(int page) {
        Pageable pageable = PageRequest.of(page, PAGE_SIZE);
        Page<Job> allPage = repository.findAll(pageable);
        List<Job> jobList = allPage.getContent();
        List<PositionBean> positionBeanList = new ArrayList<>();
        if (jobList != null) {
            for (Job job : jobList) {
                PositionBean bean = convertData(job);
                positionBeanList.add(bean);
            }
        }
        return positionBeanList;
    }

    @Override
    public PositionBean getJobById(String id) {
        if(DataUtils.isEmpty(id)){
            return null;
        }
        Job job = repository.findById(id);
        PositionBean bean = convertData(job);
        return bean;
    }

    private PositionBean convertData(Job job) {
        if (job == null) {
            return null;
        }
        PositionBean bean = new PositionBean();
        bean.setDetails(job.getDetails());
        bean.setEducation(job.getEducation());
        bean.setLocation(job.getLocation());
        bean.setName(job.getName());
        bean.setSalary(job.getSalary());
        bean.setWorkYears(job.getWorkYears());
        CompanyInfo companyInfo = new CompanyInfo();
        bean.setCompany(companyInfo);
        if (null != job.getCompany()) {
            companyInfo.setCid(String.valueOf(job.getCompany().getID()));
            companyInfo.setHeadUrl(job.getCompany().getHeadUrl());
            companyInfo.setName(job.getCompany().getName());
            companyInfo.setNumber(job.getCompany().getNumber());
            companyInfo.setStage(job.getCompany().getStage());
            companyInfo.setInfo(job.getCompany().getInfo());
            companyInfo.setCapital(job.getCompany().getCapital());
            companyInfo.setPerson(job.getCompany().getPerson());
            companyInfo.setRegistrationTime(job.getCompany().getRegistrationTime());
            companyInfo.setWebsite(job.getCompany().getWebsite());
        }
        UserInfo userInfo = new UserInfo();
        bean.setUser(userInfo);
        if (null != job.getUser()) {
            userInfo.setUid(String.valueOf(job.getUser().getID()));
            userInfo.setHeadUrl(job.getUser().getHeadUrl());
            userInfo.setNick(job.getUser().getNick());
            userInfo.setPost(job.getUser().getPost());
        }
        return bean;
    }
}
