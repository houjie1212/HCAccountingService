package com.hardcore.accounting.converterV2;

import com.hardcore.accounting.model.common.Role;

/**
 * @author houjie
 * @version V1.0
 * @Project: accounting-service
 * @date 2021/1/6 11:17
 * @Copyright: 2021 All rights reserved.
 * @since jdk1.8
 */
public class RoleConverter {

  public static Role convertFrom(com.hardcore.accounting.model.persistence.Role po) {
    return po == null ? null :
        Role.builder()
            .id(po.getId())
            .code(po.getCode())
            .name(po.getName())
            .build();
  }

  public static com.hardcore.accounting.model.service.Role convertToVo(Role dto) {
    return dto == null ? null :
        com.hardcore.accounting.model.service.Role.builder()
            .id(dto.getId())
            .code(dto.getCode())
            .name(dto.getName())
            .build();
  }
}
