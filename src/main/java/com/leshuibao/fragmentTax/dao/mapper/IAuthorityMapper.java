package com.leshuibao.fragmentTax.dao.mapper;

import com.leshuibao.fragmentTax.dao.entity.AuthorityEntity;
import org.apache.ibatis.annotations.*;
import java.util.List;


@Mapper
public interface IAuthorityMapper {
@Select("SELECT `id`, `data_url`, `menu_name`, `menu_class`, `parent_id`, `status`, `memo`, `created_time`, `changed_lasttime` FROM `authority`")
@Results({
@Result(property = "id", column = "id"), 
@Result(property = "dataUrl", column = "data_url"), 
@Result(property = "menuName", column = "menu_name"), 
@Result(property = "menuClass", column = "menu_class"), 
@Result(property = "parentId", column = "parent_id"), 
@Result(property = "status", column = "status"), 
@Result(property = "memo", column = "memo"), 
@Result(property = "createdTime", column = "created_time"), 
@Result(property = "changedLasttime", column = "changed_lasttime")
})
List<AuthorityEntity> queryAll();
@Select("SELECT `id`, `data_url`, `menu_name`, `menu_class`, `parent_id`, `status`, `memo`, `created_time`, `changed_lasttime` FROM `authority` WHERE `id` = #{id}")
@Results({
@Result(property = "id", column = "id"), 
@Result(property = "dataUrl", column = "data_url"), 
@Result(property = "menuName", column = "menu_name"), 
@Result(property = "menuClass", column = "menu_class"), 
@Result(property = "parentId", column = "parent_id"), 
@Result(property = "status", column = "status"), 
@Result(property = "memo", column = "memo"), 
@Result(property = "createdTime", column = "created_time"), 
@Result(property = "changedLasttime", column = "changed_lasttime")
})
AuthorityEntity queryByKey(@Param("id") String id);

@Insert("INSERT INTO `authority`(`id`, `data_url`, `menu_name`, `menu_class`, `parent_id`, `status`, `memo`, `created_time`) VALUES(#{id}, #{dataUrl}, #{menuName}, #{menuClass}, #{parentId}, #{status}, #{memo}, #{createdTime})")
void insert(AuthorityEntity authorityEntity);

@Update("UPDATE `authority` SET id=#{id}, data_url=#{dataUrl}, menu_name=#{menuName}, menu_class=#{menuClass}, parent_id=#{parentId}, status=#{status}, memo=#{memo}, created_time=#{createdTime} WHERE `id` = #{id}")
void update(AuthorityEntity authorityEntity);

@Delete("DELETE FROM `authority` WHERE `id` = #{id}")
void delete(@Param("id") String id);

}