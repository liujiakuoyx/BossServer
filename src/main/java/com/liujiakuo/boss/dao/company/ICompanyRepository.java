package com.liujiakuo.boss.dao.company;

import com.liujiakuo.boss.dao.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICompanyRepository extends JpaRepository<Company, Long> {
    final String TABLE_NAME = "company";//表名
    final String USER_KEY = "c_name";//key字段名

    @Query(value = "select * from " + TABLE_NAME + " where " + USER_KEY + " like %:name%", nativeQuery = true)
    public List<Company> findLikeName(@Param("name") String name);
}