package com.hardcore.accounting.dao.mapper;

import com.hardcore.accounting.model.persistence.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserInfoMapper {

    @Select("SELECT id, username, password, create_time, update_time FROM hcas_userinfo WHERE id = #{id}")
    UserInfo getUserInfoById(@Param("id") Long id);

    @Select("SELECT id, username, password, salt, create_time, update_time FROM hcas_userinfo WHERE username = #{username}")
    UserInfo getUserInfoByUsername(@Param("username") String username);

    @Insert("INSERT INTO hcas_userinfo (username, password, salt, create_time) VALUES (#{username}, #{password}, #{salt}, #{createTime})")
    int createNewUser(UserInfo userInfo);

}
