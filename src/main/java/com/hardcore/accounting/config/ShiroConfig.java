package com.hardcore.accounting.config;

import lombok.val;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

@Configuration
public class ShiroConfig {

    public static final int HASH_ITERATIONS = 1000;

    @Bean
    public SecurityManager securityManager(Realm realm) {
        val securityManager = new DefaultWebSecurityManager(realm);
        return securityManager;
    }

    /**
     * Shiro filter factory bean.
     * @param securityManager security manager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        val shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        val shiroFilterMap = new LinkedHashMap<String, String>();
        // TODO consider different HTTP method may need different filter.
        shiroFilterMap.put("/v1.0/session/*", "anon");
        shiroFilterMap.put("/v1.0/users/*", "anon");
        shiroFilterMap.put("/v1.0/roles/*", "anon");
        shiroFilterMap.put("/**", "authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(shiroFilterMap);
        return shiroFilterFactoryBean;
    }

    /**
     * Hashed credential matcher.
     * @return
     */
    @Bean
    public HashedCredentialsMatcher matcher() {
        val matcher = new HashedCredentialsMatcher();
        matcher.setHashAlgorithmName(Sha256Hash.ALGORITHM_NAME);
        matcher.setHashIterations(HASH_ITERATIONS);
        matcher.setHashSalted(true);
        matcher.setStoredCredentialsHexEncoded(false);
        return matcher;
    }
}
