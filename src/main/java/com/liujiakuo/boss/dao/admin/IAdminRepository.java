package com.liujiakuo.boss.dao.admin;

import com.liujiakuo.boss.base.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IAdminRepository extends BaseRepository<Admin> {
    String TABLE_NAME = "boss_admin";//表名

    @Query(value = "SELECT * FROM " + TABLE_NAME + " WHERE admin_key=:key", nativeQuery = true)
    Admin getAdminByKey(@Param("key") String key);
}
