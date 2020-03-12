package com.hardcore.accounting.dao;

import com.hardcore.accounting.model.persistence.UserInfo;
import org.springframework.stereotype.Repository;

@Repository
public class UserInfoDaoImpl implements UserInfoDao {

    @Override
    public UserInfo getUserInfoById(Long userId) {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(userId);
        userInfo.setUsername("test");
        return userInfo;
    }
}
