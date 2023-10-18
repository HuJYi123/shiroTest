package com.example.springboot_02.mapper;

import com.example.springboot_02.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * className:UserMapper
 * Package:com.example.springboot_02.mapper
 * Description: TODO
 *
 * @Date: 2023/10/7 10:17
 * @Author:hjy
 */

@Mapper
public interface UserMapper {
    @Select("select * from user where password = #{password} and name = #{name}")
    User login(User u);

    @Insert("insert into user(name, password, salt) values (#{name}, #{password}, #{salt})")
    void register(User user);

    @Select("select * from user where name = #{name};")
    User findByName(String name);

    @Select("select id from user where name = #{name};")
    Integer findId(String name);
}
