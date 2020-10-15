package com.hardcore.accounting.manager;

import com.hardcore.accounting.converterV2.RoleConverter;
import com.hardcore.accounting.dao.RoleDao;
import com.hardcore.accounting.model.common.Role;
import org.springframework.stereotype.Service;

/**
 * @author houjie
 * @version V1.0
 * @Project: guorent-xuanxue-center
 * @date 2020/10/15 10:37
 * @Copyright: 2020 All rights reserved.
 * @since jdk1.8
 */
@Service
public class RoleManagerImpl implements RoleManager {

  private final RoleDao roleDao;

  public RoleManagerImpl(RoleDao roleDao) {
    this.roleDao = roleDao;
  }

  @Override
  public Role getRole(Long id) {
    Role role = RoleConverter.convertFrom(roleDao.getRole(id));
    if (role != null) role.setName("test");
    return role;
  }
}
