package com.hardcore.accounting.controller;

import com.hardcore.accounting.controller.v1.UserController;
import com.hardcore.accounting.converter.c2s.UserInfoC2SConverter;
import com.hardcore.accounting.exception.GlobalExceptionHandler;
import com.hardcore.accounting.exception.ResourceNotFoundException;
import com.hardcore.accounting.manager.UserInfoManager;
import com.hardcore.accounting.model.common.UserInfo;
import lombok.val;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    private MockMvc mockMvc;

    @Mock
    private UserInfoManager userInfoManager;
    @Mock
    private UserInfoC2SConverter userInfoC2SConverter;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(userController)
                .setControllerAdvice(new GlobalExceptionHandler())
                .build();
    }

    @AfterEach
    void teardown() {
        reset(userInfoManager);
        reset(userInfoC2SConverter);
    }

    @Test
    void testGetUserInfoByUserId() throws Exception {
        // Arrange
        val userId = 10L;
        val username = "hardcore";
        val password = "hardcore";

        val userInfoCommon = UserInfo.builder()
                .id(userId)
                .username(username)
                .password(password)
                .build();

        doReturn(userInfoCommon).when(userInfoManager).getUserInfoByUserId(userId);

        val userInfoService = com.hardcore.accounting.model.service.UserInfo.builder()
                .id(userId)
                .username(username)
                .build();

        doReturn(userInfoService).when(userInfoC2SConverter).convert(userInfoCommon);

        // Act & Assert
        mockMvc.perform(get("/v1.0/users/" + userId))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string("{\"id\":10,\"username\":\"hardcore\"}"));

        verify(userInfoManager).getUserInfoByUserId(userId);
        verify(userInfoC2SConverter).convert(userInfoCommon);
    }

    @Test
    void testGetUserInfoByUserIdWithInvalidUserId() throws Exception {
        // Arrange
        val userId = -100L;
        doThrow(new ResourceNotFoundException(String.format("User %s was not found", userId)))
                .when(userInfoManager)
                .getUserInfoByUserId(anyLong());

        // Act & Assert
        mockMvc.perform(get("/v1.0/users/" + userId))
                .andExpect(status().is4xxClientError())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string("{\"statusCode\":404,\"message\":\"User -100 was not found\",\"code\":\"USER_NOT_FOUND\",\"errorType\":\"Client\"}"));
    }
}
