package com.leshuibao.fragmentTax.dao.mapper;

import com.leshuibao.fragmentTax.dao.entity.PayeeEntity;
import com.leshuibao.fragmentTax.dto.request.ShowOrdersReqDto;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface IPayeeMapper {
    @Select("SELECT `id`, `payee_name`, `payee_cidno`, `payee_cid_url`, `payee_type`, `user_id`, `status`, `memo`, `created_time`, `changed_lasttime` FROM `payee`")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "payeeName", column = "payee_name"),
            @Result(property = "payeeCidno", column = "payee_cidno"),
            @Result(property = "payeeCidUrl", column = "payee_cid_url"),
            @Result(property = "payeeType", column = "payee_type"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "status", column = "status"),
            @Result(property = "memo", column = "memo"),
            @Result(property = "createdTime", column = "created_time"),
            @Result(property = "changedLasttime", column = "changed_lasttime")
    })
    List<PayeeEntity> queryAll();

    @Select("SELECT `id`, `payee_name`, `payee_cidno`, `payee_cid_url`, `payee_type`, `user_id`, `status`, `memo`, `created_time`, `changed_lasttime` FROM `payee` WHERE `id` = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "payeeName", column = "payee_name"),
            @Result(property = "payeeCidno", column = "payee_cidno"),
            @Result(property = "payeeCidUrl", column = "payee_cid_url"),
            @Result(property = "payeeType", column = "payee_type"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "status", column = "status"),
            @Result(property = "memo", column = "memo"),
            @Result(property = "createdTime", column = "created_time"),
            @Result(property = "changedLasttime", column = "changed_lasttime")
    })
    PayeeEntity queryByKey(@Param("id") String id);

    @Select("SELECT `id`, `payee_name`, `payee_cidno`, `payee_cid_url`, `payee_type`, `user_id`, `status`, `memo`, `created_time`, `changed_lasttime` FROM `payee` WHERE `user_id` = #{user_id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "payeeName", column = "payee_name"),
            @Result(property = "payeeCidno", column = "payee_cidno"),
            @Result(property = "payeeCidUrl", column = "payee_cid_url"),
            @Result(property = "payeeType", column = "payee_type"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "status", column = "status"),
            @Result(property = "memo", column = "memo"),
            @Result(property = "createdTime", column = "created_time"),
            @Result(property = "changedLasttime", column = "changed_lasttime")
    })
    List<PayeeEntity> queryByUserId(@Param("user_id") String user_id);

    @Insert("INSERT INTO `payee`(`id`, `payee_name`, `payee_cidno`, `payee_cid_url`, `payee_type`, `user_id`, `status`, `memo`, `created_time`) VALUES(#{id}, #{payeeName}, #{payeeCidno}, #{payeeCidUrl}, #{payeeType}, #{userId}, #{status}, #{memo}, #{createdTime})")
    void insert(PayeeEntity payeeEntity);

    @Update("UPDATE `payee` SET id=#{id}, payee_name=#{payeeName}, payee_cidno=#{payeeCidno}, payee_cid_url=#{payeeCidUrl}, payee_type=#{payeeType}, user_id=#{userId}, status=#{status}, memo=#{memo}, created_time=#{createdTime} WHERE `id` = #{id}")
    void update(PayeeEntity payeeEntity);

    @Delete("DELETE FROM `payee` WHERE `id` = #{id}")
    void delete(@Param("id") String id);

}