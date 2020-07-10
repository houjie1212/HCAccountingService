package com.hardcore.accounting.model.persistence;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

/**
 * @author houjie
 * @version V1.0
 * @date 2020/4/25 22:08
 */
@Data
@Builder
public class Tag {

  private Long id;
  private String description;
  private Long userId;
  private Integer status;
  private LocalDate createTime;
  private LocalDate updateTime;
}
