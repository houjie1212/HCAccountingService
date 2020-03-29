package com.hardcore.accounting.manager;

import com.hardcore.accounting.converter.p2c.UserInfoP2CConverter;
import com.hardcore.accounting.dao.UserInfoDao;
import com.hardcore.accounting.exception.ResourceNotFoundException;
import com.hardcore.accounting.model.persistence.UserInfo;
import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

public class UserInfoManagerTest {

    private UserInfoManager userInfoManager;

    @Mock
    private UserInfoDao userInfoDao;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
        userInfoManager = new UserInfoManagerImpl(userInfoDao, new UserInfoP2CConverter());
    }

    @Test
    void getUserInfoByUserId() {
        // Arrange
        val userId = 1L;
        val username = "hardcore";
        val password = "hardcore";
        val createTime = LocalDate.now();

        val userInfo = UserInfo.builder()
                .id(userId)
                .username(username)
                .password(password)
                .createTime(createTime)
                .build();

        doReturn(userInfo).when(userInfoDao).getUserInfoById(userId);

        // Act
        val result = userInfoManager.getUserInfoByUserId(userId);

        // Assert
        assertThat(result).isNotNull()
                .hasFieldOrPropertyWithValue("id", userId)
                .hasFieldOrPropertyWithValue("username", username)
                .hasFieldOrPropertyWithValue("password", password);

        verify(userInfoDao).getUserInfoById(eq(userId));
    }

    @Test
    void testGetUserInfoByUserIdWithInvalidUserId() {
        // Arrange
        val userId = -1L;

        doReturn(null).when(userInfoDao).getUserInfoById(userId);

        // Act & Assert
        assertThrows(ResourceNotFoundException.class, () -> userInfoManager.getUserInfoByUserId(userId));

        verify(userInfoDao).getUserInfoById(userId);
    }
}
