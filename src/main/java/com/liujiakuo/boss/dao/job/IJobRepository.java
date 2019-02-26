package com.liujiakuo.boss.dao.job;

import com.liujiakuo.boss.base.BaseRepository;
import com.liujiakuo.boss.bean.PositionBean;
import com.liujiakuo.boss.dao.company.Company;
import com.liujiakuo.boss.dao.job.Job;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IJobRepository extends BaseRepository<Job> {
    String TABLE_NAME = "job";//表名
    String USER_KEY = "j_name";//key字段名
    String JOB_ID = "j_id";//key字段名

    @Query(value = "select * from " + TABLE_NAME + " where " + USER_KEY + " like %:name%", nativeQuery = true)
    List<Job> findLikeName(@Param("name") String name);

    @Query(value = "select * from " + TABLE_NAME + " where " + JOB_ID + " =:id", nativeQuery = true)
    Job findById(@Param("id") String id);
}
