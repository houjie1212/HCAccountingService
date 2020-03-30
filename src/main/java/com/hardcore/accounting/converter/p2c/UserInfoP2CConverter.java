package com.hardcore.accounting.converter.p2c;

import com.hardcore.accounting.model.persistence.UserInfo;

import com.google.common.base.Converter;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Component;

@Component
@EqualsAndHashCode(callSuper = true)
public class UserInfoP2CConverter extends Converter<UserInfo, com.hardcore.accounting.model.common.UserInfo> {

    @Override
    protected com.hardcore.accounting.model.common.UserInfo doForward(UserInfo userInfo) {
        return com.hardcore.accounting.model.common.UserInfo.builder()
                .id(userInfo.getId())
                .username(userInfo.getUsername())
                .password(userInfo.getPassword())
                .salt(userInfo.getSalt())
                .build();
    }

    @Override
    protected UserInfo doBackward(com.hardcore.accounting.model.common.UserInfo userInfo) {
        return UserInfo.builder()
                .id(userInfo.getId())
                .username(userInfo.getUsername())
                .password(userInfo.getPassword())
                .build();
    }
}
