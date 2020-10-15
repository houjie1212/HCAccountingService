package com.hardcore.accounting.controller.v1;

import com.hardcore.accounting.converterV2.RoleConverter;
import com.hardcore.accounting.manager.RoleManager;
import com.hardcore.accounting.model.service.Role;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author houjie
 * @version V1.0
 * @Project: guorent-xuanxue-center
 * @date 2020/10/15 10:48
 * @Copyright: 2020 All rights reserved.
 * @since jdk1.8
 */
@RestController
@RequestMapping("v1.0/roles")
public class RoleController {

  private final RoleManager roleManager;

  public RoleController(RoleManager roleManager) {
    this.roleManager = roleManager;
  }

  @GetMapping("{id}")
  public ResponseEntity<Role> getRole(@PathVariable Long id) {
    return ResponseEntity.ok(RoleConverter.convertToVo(roleManager.getRole(id)));
  }
}
