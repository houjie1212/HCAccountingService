package com.hardcore.accounting.dao.mapper;

import com.hardcore.accounting.model.persistence.Tag;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author houjie
 * @version V1.0
 * @date 2020/4/25 22:20
 */
@Mapper
public interface TagMapper {

  @Insert("INSERT INTO hcas_tag(description, user_id, status, create_time) "
      + "VALUES (#{description}, #{userId}, #{status}, #{createTime})")
  int insertTag(Tag tag);
}
