package com.leshuibao.fragmentTax.dao.mapper;

import com.leshuibao.fragmentTax.dao.entity.PayerEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface IPayerMapper {
    @Select("SELECT `id`, `payer_code`, `payer_name`, `user_id`, `payer_addr`, `payer_phone`, `payer_bank`, `payer_bank_no`, `status`, `payer_type`, `memo`, `create_time`, `changed_lasttime` FROM `payer`")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "payerCode", column = "payer_code"),
            @Result(property = "payerName", column = "payer_name"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "payerAddr", column = "payer_addr"),
            @Result(property = "payerPhone", column = "payer_phone"),
            @Result(property = "payerBank", column = "payer_bank"),
            @Result(property = "payerBankNo", column = "payer_bank_no"),
            @Result(property = "status", column = "status"),
            @Result(property = "payerType", column = "payer_type"),
            @Result(property = "memo", column = "memo"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "changedLasttime", column = "changed_lasttime")
    })
    List<PayerEntity> queryAll();

    @Select("SELECT `id`, `payer_code`, `payer_name`, `user_id`, `payer_addr`, `payer_phone`, `payer_bank`, `payer_bank_no`, `status`, `payer_type`, `memo`, `create_time`, `changed_lasttime` FROM `payer` WHERE `id` = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "payerCode", column = "payer_code"),
            @Result(property = "payerName", column = "payer_name"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "payerAddr", column = "payer_addr"),
            @Result(property = "payerPhone", column = "payer_phone"),
            @Result(property = "payerBank", column = "payer_bank"),
            @Result(property = "payerBankNo", column = "payer_bank_no"),
            @Result(property = "status", column = "status"),
            @Result(property = "payerType", column = "payer_type"),
            @Result(property = "memo", column = "memo"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "changedLasttime", column = "changed_lasttime")
    })
    PayerEntity queryByKey(@Param("id") String id);

    @Select("SELECT `id`, `payer_code`, `payer_name`, `user_id`, `payer_addr`, `payer_phone`, `payer_bank`, `payer_bank_no`, `status`, `payer_type`, `memo`, `create_time`, `changed_lasttime` FROM `payer` WHERE `user_id` = #{user_id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "payerCode", column = "payer_code"),
            @Result(property = "payerName", column = "payer_name"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "payerAddr", column = "payer_addr"),
            @Result(property = "payerPhone", column = "payer_phone"),
            @Result(property = "payerBank", column = "payer_bank"),
            @Result(property = "payerBankNo", column = "payer_bank_no"),
            @Result(property = "status", column = "status"),
            @Result(property = "payerType", column = "payer_type"),
            @Result(property = "memo", column = "memo"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "changedLasttime", column = "changed_lasttime")
    })
    List<PayerEntity> queryByUserId(@Param("user_id") String user_id);


    @Insert("INSERT INTO `payer`(`id`, `payer_code`, `payer_name`, `user_id`, `payer_addr`, `payer_phone`, `payer_bank`, `payer_bank_no`, `status`, `payer_type`, `memo`, `create_time`) VALUES(#{id}, #{payerCode}, #{payerName}, #{userId}, #{payerAddr}, #{payerPhone}, #{payerBank}, #{payerBankNo}, #{status}, #{payerType}, #{memo}, #{createTime})")
    void insert(PayerEntity payerEntity);

    @Update("UPDATE `payer` SET id=#{id}, payer_code=#{payerCode}, payer_name=#{payerName}, user_id=#{userId}, payer_addr=#{payerAddr}, payer_phone=#{payerPhone}, payer_bank=#{payerBank}, payer_bank_no=#{payerBankNo}, status=#{status}, payer_type=#{payerType}, memo=#{memo}, create_time=#{createTime} WHERE `id` = #{id}")
    void update(PayerEntity payerEntity);

    @Delete("DELETE FROM `payer` WHERE `id` = #{id}")
    void delete(@Param("id") String id);

}