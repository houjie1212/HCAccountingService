package com.hardcore.accounting.dao;

import com.hardcore.accounting.dao.mapper.UserInfoMapper;
import com.hardcore.accounting.model.persistence.UserInfo;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class UserInfoDaoTest {

    @Mock
    private UserInfoMapper userInfoMapper;

    /*
    private UserInfoDao userInfoDao;

    @BeforeEach
    void setup() {
        userInfoDao = new UserInfoDaoImpl(userInfoMapper);
    }*/

    @InjectMocks
    private UserInfoDaoImpl userInfoDao;


    @Test
    void testGetUserInfoById() {
        // Arrange
        val userId = 100L;
        val username = "hardcore";
        val password = "hardcore";
        val createTime = LocalDate.now();

        val userInfo = UserInfo.builder()
                .id(userId)
                .username(username)
                .password(password)
                .createTime(createTime)
                .build();

        doReturn(userInfo).when(userInfoMapper).getUserInfoById(userId);

        // Act
        val result = userInfoDao.getUserInfoById(userId);

        // Assert
        assertEquals(userInfo, result);

        verify(userInfoMapper).getUserInfoById(userId);
    }
}
