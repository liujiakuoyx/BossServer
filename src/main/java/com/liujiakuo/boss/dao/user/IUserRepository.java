package com.liujiakuo.boss.dao.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IUserRepository extends JpaRepository<User, Long> {
    final String TABLE_NAME = "user";//表名
    final String USER_KEY = "user_key";//key字段名

    @Query(value = "select * from " + TABLE_NAME + " where " + USER_KEY + "=:key", nativeQuery = true)
    public List<User> findUserByKey(@Param("key") String key);
}
