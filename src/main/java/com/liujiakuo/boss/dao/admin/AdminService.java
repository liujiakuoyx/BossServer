package com.liujiakuo.boss.dao.admin;

import com.liujiakuo.boss.utils.DataUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    private IAdminRepository repository;

    public Admin login(String key, String pass) {
        if (DataUtils.isEmpty(key) || DataUtils.isEmpty(pass)) {
            return null;
        }
        Admin admin = repository.getAdminByKey(key);
        if (admin == null) {
            return null;
        }
        String adminPass = admin.getPass();
        if (adminPass.equals(pass)) {
            return admin;
        } else {
            return null;
        }
    }
}
