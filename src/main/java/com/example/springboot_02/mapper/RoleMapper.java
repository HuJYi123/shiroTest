package com.example.springboot_02.mapper;

import com.example.springboot_02.pojo.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * className:RoleMapper
 * Package:com.example.springboot_02.mapper
 * Description: TODO
 *
 * @Date: 2023/10/18 10:26
 * @Author:hjy
 */
@Mapper
public interface RoleMapper {

    @Select("select * from role where id in (select roleid from user_role where userid = #{userId});")
    List<Role> getRolesByUserId(Integer userId);
}
