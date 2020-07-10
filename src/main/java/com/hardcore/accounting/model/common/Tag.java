package com.hardcore.accounting.model.common;

import lombok.Builder;
import lombok.Data;

/**
 * @author houjie
 * @version V1.0
 * @date 2020/4/25 22:15
 */
@Data
@Builder
public class Tag {

  private Long id;
  private String description;
  private Long userId;
  private Integer status;
}
