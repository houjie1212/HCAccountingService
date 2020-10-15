package com.hardcore.accounting.dao;

import com.hardcore.accounting.dao.mapper.RoleMapper;
import com.hardcore.accounting.model.persistence.Role;
import org.springframework.stereotype.Repository;

/**
 * @author houjie
 * @version V1.0
 * @Project: guorent-xuanxue-center
 * @date 2020/10/15 10:26
 * @Copyright: 2020 All rights reserved.
 * @since jdk1.8
 */
@Repository
public class RoleDaoImpl implements RoleDao {

  private final RoleMapper roleMapper;

  public RoleDaoImpl(RoleMapper roleMapper) {
    this.roleMapper = roleMapper;
  }

  @Override
  public Role getRole(Long id) {
    return roleMapper.getRole(id);
  }
}
