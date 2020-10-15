package com.hardcore.accounting.dao;

import com.hardcore.accounting.model.persistence.Role;

/**
 * @author houjie
 * @version V1.0
 * @Project: guorent-xuanxue-center
 * @date 2020/10/15 10:25
 * @Copyright: 2020 All rights reserved.
 * @since jdk1.8
 */
public interface RoleDao {

  Role getRole(Long id);
}
