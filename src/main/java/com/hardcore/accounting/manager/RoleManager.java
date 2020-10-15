package com.hardcore.accounting.manager;

import com.hardcore.accounting.model.common.Role;

/**
 * @author houjie
 * @version V1.0
 * @Project: guorent-xuanxue-center
 * @date 2020/10/15 10:36
 * @Copyright: 2020 All rights reserved.
 * @since jdk1.8
 */
public interface RoleManager {

  Role getRole(Long id);
}
