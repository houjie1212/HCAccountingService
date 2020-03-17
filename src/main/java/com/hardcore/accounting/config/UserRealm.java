package com.hardcore.accounting.config;

import com.hardcore.accounting.manager.UserInfoManager;
import lombok.val;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserRealm extends AuthorizingRealm {

    private final UserInfoManager userInfoManager;

    @Autowired
    public UserRealm(HashedCredentialsMatcher matcher, UserInfoManager userInfoManager) {
        super(matcher);
        this.userInfoManager = userInfoManager;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        // String password = new String((char[]) token.getCredentials());

        val userInfo = userInfoManager.getUserInfoByUsername(username);
        return new SimpleAuthenticationInfo(username, userInfo.getPassword(), ByteSource.Util.bytes(userInfo.getSalt()), this.getName());
    }
}
