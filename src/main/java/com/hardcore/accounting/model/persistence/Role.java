package com.hardcore.accounting.model.persistence;

import lombok.Builder;
import lombok.Data;

/**
 * @author houjie
 * @version V1.0
 * @Project: accounting-service
 * @date 2021/1/6 11:15
 * @Copyright: 2021 All rights reserved.
 * @since jdk1.8
 */
@Data
@Builder
public class Role {

  private Long id;
  private String code;
  private String name;

}
