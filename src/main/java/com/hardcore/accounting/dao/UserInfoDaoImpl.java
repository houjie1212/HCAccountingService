package com.hardcore.accounting.dao;

import com.hardcore.accounting.dao.mapper.UserInfoMapper;
import com.hardcore.accounting.model.persistence.UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor(onConstructor =  @__(@Autowired))
public class UserInfoDaoImpl implements UserInfoDao {

    private final UserInfoMapper userInfoMapper;

//    @Autowired
//    public UserInfoDaoImpl(UserInfoMapper userInfoMapper) {
//        this.userInfoMapper = userInfoMapper;
//    }

    @Override
    public UserInfo getUserInfoById(Long userId) {
        return userInfoMapper.getUserInfoById(userId);
    }
}
