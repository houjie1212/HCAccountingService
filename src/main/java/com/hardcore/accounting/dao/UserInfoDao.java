package com.hardcore.accounting.dao;

import com.hardcore.accounting.model.persistence.UserInfo;

public interface UserInfoDao {

    UserInfo getUserInfoById(Long userId);

    UserInfo getUserInfoByUsername(String username);

    void createNewUser(UserInfo userInfo);
}
