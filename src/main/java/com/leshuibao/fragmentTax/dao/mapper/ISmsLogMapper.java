package com.leshuibao.fragmentTax.dao.mapper;

import com.leshuibao.fragmentTax.dao.entity.SmsLogEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface ISmsLogMapper {
    @Select("SELECT `id`, `phone`, `sms_code`, `request_id`, `status_code`, `message`, `bizid`, `memo`, `create_time`, `changed_lasttime` FROM `sms_log`")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "phone", column = "phone"),
            @Result(property = "smsCode", column = "sms_code"),
            @Result(property = "requestId", column = "request_id"),
            @Result(property = "statusCode", column = "status_code"),
            @Result(property = "message", column = "message"),
            @Result(property = "bizid", column = "bizid"),
            @Result(property = "memo", column = "memo"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "changedLasttime", column = "changed_lasttime")
    })
    List<SmsLogEntity> queryAll();

    @Select("SELECT `id`, `phone`, `sms_code`, `request_id`, `status_code`, `message`, `bizid`, `memo`, `create_time`, `changed_lasttime` FROM `sms_log` WHERE `id` = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "phone", column = "phone"),
            @Result(property = "smsCode", column = "sms_code"),
            @Result(property = "requestId", column = "request_id"),
            @Result(property = "statusCode", column = "status_code"),
            @Result(property = "message", column = "message"),
            @Result(property = "bizid", column = "bizid"),
            @Result(property = "memo", column = "memo"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "changedLasttime", column = "changed_lasttime")
    })
    SmsLogEntity queryByKey(@Param("id") String id);

    @Insert("INSERT INTO `sms_log`(`id`, `phone`, `sms_code`, `request_id`, `status_code`, `message`, `bizid`, `memo`, `create_time`) VALUES(#{id}, #{phone}, #{smsCode}, #{requestId}, #{statusCode}, #{message}, #{bizid}, #{memo}, #{createTime})")
    void insert(SmsLogEntity sms_infoEntity);

    @Update("UPDATE `sms_log` SET id=#{id}, phone=#{phone}, sms_code=#{smsCode}, request_id=#{requestId}, status_code=#{statusCode}, message=#{message}, bizid=#{bizid}, memo=#{memo}, createTime=#{createTime} WHERE `phone` = #{phone}")
    void update(SmsLogEntity sms_infoEntity);

    @Update("UPDATE `sms_log` SET sms_code=#{smsCode} WHERE `phone` = #{phone}")
    void updateByPhone(@Param("phone") String phone, @Param("smsCode") String smsCode);

    @Delete("DELETE FROM `sms_log` WHERE `phone` = #{phone}")
    void delete(@Param("phone") String phone);

    @Select("SELECT `id`, `phone`, `sms_code`, `request_id`, `status_code`, `message`, `bizid`, `memo`, `create_time`, `changed_lasttime` FROM `sms_log` WHERE `phone` = #{phone}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "phone", column = "phone"),
            @Result(property = "smsCode", column = "sms_code"),
            @Result(property = "requestId", column = "request_id"),
            @Result(property = "statusCode", column = "status_code"),
            @Result(property = "message", column = "message"),
            @Result(property = "bizid", column = "bizid"),
            @Result(property = "memo", column = "memo"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "changedLasttime", column = "changed_lasttime")
    })
    SmsLogEntity queryByPhone(@Param("phone") String phone);
}