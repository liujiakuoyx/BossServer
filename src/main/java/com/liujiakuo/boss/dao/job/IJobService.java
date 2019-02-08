package com.liujiakuo.boss.dao.job;

import com.liujiakuo.boss.dao.user.User;
import jdk.nashorn.internal.scripts.JO;

import java.util.List;

public interface IJobService {
    /**
     * 获取全部
     */
    List<Job> findAll();

    /**
     * 插入
     */
    Job insertUser(Job job);

    /**
     * 删除
     */
    void deleteJob(Job job);

    /**
     * 更新
     */
    Job updateJob(Job job);

    /**
     * 按名字查询
     */
    List<Job> findByName(String name);

    /**
     * 分页加载职位数据
     */
    List<Job> getJobList(int page);
}
