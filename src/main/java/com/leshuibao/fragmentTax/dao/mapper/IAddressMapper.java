package com.leshuibao.fragmentTax.dao.mapper;

import com.leshuibao.fragmentTax.dao.entity.AddressEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface IAddressMapper {
    @Select("SELECT `id`, `address`, `addressee_id`, `addressee_type`, `status`, `memo`, `created_time`, `changed_lasttime` FROM `address`")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "address", column = "address"),
            @Result(property = "addresseeId", column = "addressee_id"),
            @Result(property = "addresseeType", column = "addressee_type"),
            @Result(property = "status", column = "status"),
            @Result(property = "memo", column = "memo"),
            @Result(property = "createdTime", column = "created_time"),
            @Result(property = "changedLasttime", column = "changed_lasttime")
    })
    List<AddressEntity> queryAll();

    @Select("SELECT `id`, `address`, `addressee_id`, `addressee_type`, `status`, `memo`, `created_time`, `changed_lasttime` FROM `address` WHERE `id` = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "address", column = "address"),
            @Result(property = "addresseeId", column = "addressee_id"),
            @Result(property = "addresseeType", column = "addressee_type"),
            @Result(property = "status", column = "status"),
            @Result(property = "memo", column = "memo"),
            @Result(property = "createdTime", column = "created_time"),
            @Result(property = "changedLasttime", column = "changed_lasttime")
    })
    AddressEntity queryByKey(@Param("id") String id);

    @Insert("INSERT INTO `address`(`id`, `address`, `addressee_id`, `addressee_type`, `status`, `memo`, `created_time`) VALUES(#{id}, #{address}, #{addresseeId}, #{addresseeType}, #{status}, #{memo}, #{createdTime})")
    void insert(AddressEntity addressEntity);

    @Update("UPDATE `address` SET id=#{id}, address=#{address}, addressee_id=#{addresseeId}, addressee_type=#{addresseeType}, status=#{status}, memo=#{memo}, created_time=#{createdTime} WHERE `id` = #{id}")
    void update(AddressEntity addressEntity);

    @Delete("DELETE FROM `address` WHERE `id` = #{id}")
    void delete(@Param("id") String id);

}