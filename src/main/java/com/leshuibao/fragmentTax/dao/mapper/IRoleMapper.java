package com.leshuibao.fragmentTax.dao.mapper;

import com.leshuibao.fragmentTax.dao.entity.RoleEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface IRoleMapper {
    @Select("SELECT `id`, `rolename`, `user_id`, `role_desc`, `status`, `memo`, `created_time`, `changed_lasttime` FROM `role`")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "rolename", column = "rolename"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "roleDesc", column = "role_desc"),
            @Result(property = "status", column = "status"),
            @Result(property = "memo", column = "memo"),
            @Result(property = "createdTime", column = "created_time"),
            @Result(property = "changedLasttime", column = "changed_lasttime")
    })
    List<RoleEntity> queryAll();

    @Select("SELECT `id`, `rolename`, `user_id`, `role_desc`, `status`, `memo`, `created_time`, `changed_lasttime` FROM `role` WHERE `id` = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "rolename", column = "rolename"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "roleDesc", column = "role_desc"),
            @Result(property = "status", column = "status"),
            @Result(property = "memo", column = "memo"),
            @Result(property = "createdTime", column = "created_time"),
            @Result(property = "changedLasttime", column = "changed_lasttime")
    })
    RoleEntity queryByKey(@Param("id") String id);

    @Insert("INSERT INTO `role`(`id`, `rolename`, `user_id`, `role_desc`, `status`, `memo`, `created_time`) VALUES(#{id}, #{rolename}, #{userId}, #{roleDesc}, #{status}, #{memo}, #{createdTime})")
    void insert(RoleEntity roleEntity);

    @Update("UPDATE `role` SET id=#{id}, rolename=#{rolename}, user_id=#{userId}, role_desc=#{roleDesc}, status=#{status}, memo=#{memo}, created_time=#{createdTime} WHERE `id` = #{id}")
    void update(RoleEntity roleEntity);

    @Delete("DELETE FROM `role` WHERE `id` = #{id}")
    void delete(@Param("id") String id);

}