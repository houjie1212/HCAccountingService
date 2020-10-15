package com.hardcore.accounting.dao.mapper;

import com.hardcore.accounting.model.persistence.Role;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author houjie
 * @version V1.0
 * @Project: guorent-xuanxue-center
 * @date 2020/10/15 10:21
 * @Copyright: 2020 All rights reserved.
 * @since jdk1.8
 */
public interface RoleMapper {

  @Select("select id, code, name from hcas_role where id = #{id}")
  Role getRole(@Param("id") Long id);
}
