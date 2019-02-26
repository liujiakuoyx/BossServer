package com.liujiakuo.boss.dao.company;

import com.liujiakuo.boss.base.BaseRepository;
import com.liujiakuo.boss.dao.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICompanyRepository extends BaseRepository<Company> {
    String TABLE_NAME = "company";//表名
    String COMPANY_KEY = "c_name";//key字段名
    String COMPANY_ID = "c_id";

    @Query(value = "select * from " + TABLE_NAME + " where " + COMPANY_KEY + " like %:name%", nativeQuery = true)
    List<Company> findLikeName(@Param("name") String name);

    @Query(value = "select * from " + TABLE_NAME + " where " + COMPANY_ID + " =:id", nativeQuery = true)
    Company findById(@Param("id") String id);
}
