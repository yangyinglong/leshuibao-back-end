package com.leshuibao.fragmentTax.dao.mapper;

import com.leshuibao.fragmentTax.dao.entity.UserEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface IUserMapper {
    @Select("SELECT `id`, `username`, `phone`, `password`, `salt`, `mail_addr`, `status`, `memo`, `created_time`, `changed_lasttime` FROM `user`")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "phone", column = "phone"),
            @Result(property = "password", column = "password"),
            @Result(property = "salt", column = "salt"),
            @Result(property = "mailAddr", column = "mail_addr"),
            @Result(property = "status", column = "status"),
            @Result(property = "memo", column = "memo"),
            @Result(property = "createdTime", column = "created_time"),
            @Result(property = "changedLasttime", column = "changed_lasttime")
    })
    List<UserEntity> queryAll();

    @Select("SELECT `id`, `username`, `phone`, `password`, `salt`, `mail_addr`, `status`, `memo`, `created_time`, `changed_lasttime` FROM `user` WHERE `id` = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "phone", column = "phone"),
            @Result(property = "password", column = "password"),
            @Result(property = "salt", column = "salt"),
            @Result(property = "mailAddr", column = "mail_addr"),
            @Result(property = "status", column = "status"),
            @Result(property = "memo", column = "memo"),
            @Result(property = "createdTime", column = "created_time"),
            @Result(property = "changedLasttime", column = "changed_lasttime")
    })
    UserEntity queryByKey(@Param("id") String id);

    @Insert("INSERT INTO `user`(`id`, `username`, `phone`, `password`, `salt`, `mail_addr`, `status`, `memo`, `created_time`) VALUES(#{id}, #{username}, #{phone}, #{password}, #{salt}, #{mailAddr}, #{status}, #{memo}, #{createdTime})")
    void insert(UserEntity userEntity);

    @Update("UPDATE `user` SET id=#{id}, username=#{username}, phone=#{phone}, password=#{password}, salt=#{salt}, mail_addr=#{mailAddr}, status=#{status}, memo=#{memo}, created_time=#{createdTime} WHERE `id` = #{id}")
    void update(UserEntity userEntity);

    @Delete("DELETE FROM `user` WHERE `id` = #{id}")
    void delete(@Param("id") String id);

    @Select("SELECT `id`, `username`, `phone`, `password`, `salt`, `mail_addr`, `status`, `memo`, `created_time`, `changed_lasttime` FROM `user` WHERE `username` = #{username}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "phone", column = "phone"),
            @Result(property = "password", column = "password"),
            @Result(property = "salt", column = "salt"),
            @Result(property = "mailAddr", column = "mail_addr"),
            @Result(property = "status", column = "status"),
            @Result(property = "memo", column = "memo"),
            @Result(property = "createdTime", column = "created_time"),
            @Result(property = "changedLasttime", column = "changed_lasttime")
    })
    UserEntity queryByUsername(String username);

    @Select("SELECT `id`, `username`, `phone`, `password`, `salt`, `mail_addr`, `status`, `memo`, `created_time`, `changed_lasttime` FROM `user` WHERE `phone` = #{phone}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "phone", column = "phone"),
            @Result(property = "password", column = "password"),
            @Result(property = "salt", column = "salt"),
            @Result(property = "mailAddr", column = "mail_addr"),
            @Result(property = "status", column = "status"),
            @Result(property = "memo", column = "memo"),
            @Result(property = "createdTime", column = "created_time"),
            @Result(property = "changedLasttime", column = "changed_lasttime")
    })
    UserEntity queryByPhone(String phone);

    @Update("UPDATE `user` SET password=#{password} WHERE `phone` = #{phone}")
    void updateByPhone(@Param("phone") String phone, @Param("password") String password);
}