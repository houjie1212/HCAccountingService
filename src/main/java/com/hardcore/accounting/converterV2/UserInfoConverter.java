package com.hardcore.accounting.converterV2;

import com.hardcore.accounting.model.common.UserInfo;
import org.springframework.util.StringUtils;

/**
 * @author houjie
 * @version V1.0
 * @date 2020/4/25 21:55
 */
public class UserInfoConverter {

  public static UserInfo convertFrom(com.hardcore.accounting.model.persistence.UserInfo po) {
    return po == null ? null
        : UserInfo.builder()
        .id(po.getId())
        .username(po.getUsername())
        .password(po.getPassword())
        .salt(po.getSalt())
        .build();
  }

  public static UserInfo convertFrom(com.hardcore.accounting.model.service.UserInfo form) {
    return form == null ? null
        : UserInfo.builder()
        .id(form.getId())
        .username(StringUtils.trimWhitespace(form.getUsername()))
        .password(form.getPassword())
        .build();
  }

  public static com.hardcore.accounting.model.persistence.UserInfo convertToPo(UserInfo dto) {
    return dto == null ? null
        : com.hardcore.accounting.model.persistence.UserInfo.builder()
        .id(dto.getId())
        .username(dto.getUsername())
        .password(dto.getPassword())
        .build();
  }

  public static com.hardcore.accounting.model.service.UserInfo convertToVo(UserInfo dto) {
    return dto == null ? null
        : com.hardcore.accounting.model.service.UserInfo.builder()
        .id(dto.getId())
        .username(dto.getUsername())
        .build();
  }
}
