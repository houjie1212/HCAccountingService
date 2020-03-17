package com.hardcore.accounting.controller.v1;

import com.hardcore.accounting.converter.c2s.UserInfoC2SConverter;
import com.hardcore.accounting.manager.UserInfoManager;
import com.hardcore.accounting.model.service.UserInfo;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController("userControllerV1")
@RequestMapping("v1.0/users")
@Slf4j
public class UserController {

    private final UserInfoManager userInfoManager;
    private final UserInfoC2SConverter userInfoC2SConverter;

    @Autowired
    public UserController(UserInfoManager userInfoManager,
                          UserInfoC2SConverter userInfoC2SConverter) {
        this.userInfoManager = userInfoManager;
        this.userInfoC2SConverter = userInfoC2SConverter;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserInfo> getUserInfoByUserId(@PathVariable("id") Long userId) {
        val userInfo = userInfoManager.getUserInfoByUserId(userId);
        return ResponseEntity.ok(userInfoC2SConverter.convert(userInfo));
    }

    @PostMapping
    public ResponseEntity<UserInfo> register(@RequestParam String username, @RequestParam String password) {
        val userInfo = userInfoManager.register(username, password);
        return ResponseEntity.ok(userInfoC2SConverter.convert(userInfo));
    }

    @GetMapping()
    public ResponseEntity getUsers(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        return ResponseEntity.ok(Collections.emptyList());
    }
}
