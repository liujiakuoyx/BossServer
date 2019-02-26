package com.liujiakuo.boss.dao.user;

import com.liujiakuo.boss.base.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IUserRepository extends BaseRepository<User> {
    String TABLE_NAME = "user";//表名
    String USER_KEY = "user_key";//key字段名
    String USER_ID = "uid";

    @Query(value = "select * from " + TABLE_NAME + " where " + USER_KEY + "=:key", nativeQuery = true)
    List<User> findUserByKey(@Param("key") String key);

    @Query(value = "select * from " + TABLE_NAME + " where " + USER_ID + "=:id", nativeQuery = true)
    User findUserById(@Param("id") String id);
}
