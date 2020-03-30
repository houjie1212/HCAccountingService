package com.hardcore.accounting.converter.c2s;

import com.hardcore.accounting.model.common.UserInfo;

import com.google.common.base.Converter;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Component;

@Component
@EqualsAndHashCode(callSuper = true)
public class UserInfoC2SConverter extends Converter<UserInfo, com.hardcore.accounting.model.service.UserInfo> {

    @Override
    protected com.hardcore.accounting.model.service.UserInfo doForward(UserInfo userInfo) {
        return com.hardcore.accounting.model.service.UserInfo.builder()
                .id(userInfo.getId())
                .username(userInfo.getUsername())
                .build();
    }

    @Override
    protected UserInfo doBackward(com.hardcore.accounting.model.service.UserInfo userInfo) {
        // throw new UnsupportedOperationException(); // 不支持反向转换
        return UserInfo.builder()
                .id(userInfo.getId())
                .username((userInfo.getUsername()))
                .build();
    }
}
