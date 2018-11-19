package com.leshuibao.fragmentTax.dao.mapper;

import com.leshuibao.fragmentTax.dao.entity.RoleAuthorityEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface IRoleAuthorityMapper {
    @Select("SELECT `id`, `role_id`, `authority_id`, `status`, `memo`, `created_time`, `changed_lasttime` FROM `role_authority`")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "roleId", column = "role_id"),
            @Result(property = "authorityId", column = "authority_id"),
            @Result(property = "status", column = "status"),
            @Result(property = "memo", column = "memo"),
            @Result(property = "createdTime", column = "created_time"),
            @Result(property = "changedLasttime", column = "changed_lasttime")
    })
    List<RoleAuthorityEntity> queryAll();

    @Select("SELECT `id`, `role_id`, `authority_id`, `status`, `memo`, `created_time`, `changed_lasttime` FROM `role_authority` WHERE `id` = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "roleId", column = "role_id"),
            @Result(property = "authorityId", column = "authority_id"),
            @Result(property = "status", column = "status"),
            @Result(property = "memo", column = "memo"),
            @Result(property = "createdTime", column = "created_time"),
            @Result(property = "changedLasttime", column = "changed_lasttime")
    })
    RoleAuthorityEntity queryByKey(@Param("id") String id);

    @Insert("INSERT INTO `role_authority`(`id`, `role_id`, `authority_id`, `status`, `memo`, `created_time`) VALUES(#{id}, #{roleId}, #{authorityId}, #{status}, #{memo}, #{createdTime})")
    void insert(RoleAuthorityEntity role_authorityEntity);

    @Update("UPDATE `role_authority` SET id=#{id}, role_id=#{roleId}, authority_id=#{authorityId}, status=#{status}, memo=#{memo}, created_time=#{createdTime} WHERE `id` = #{id}")
    void update(RoleAuthorityEntity role_authorityEntity);

    @Delete("DELETE FROM `role_authority` WHERE `id` = #{id}")
    void delete(@Param("id") String id);

}