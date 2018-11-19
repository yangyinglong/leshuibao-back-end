package com.leshuibao.fragmentTax.dao.mapper;

import com.leshuibao.fragmentTax.dao.entity.PaymentEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface IPaymentMapper {
    @Select("SELECT `id`, `user_id`, `order_id`, `pay_type`, `pay_trace_code`, `pay_for`, `status`, `memo`, `create_time`, `changed_lasttime` FROM `payment`")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "orderId", column = "order_id"),
            @Result(property = "payType", column = "pay_type"),
            @Result(property = "payTraceCode", column = "pay_trace_code"),
            @Result(property = "payFor", column = "pay_for"),
            @Result(property = "status", column = "status"),
            @Result(property = "memo", column = "memo"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "changedLasttime", column = "changed_lasttime")
    })
    List<PaymentEntity> queryAll();

    @Select("SELECT `id`, `user_id`, `order_id`, `pay_type`, `pay_trace_code`, `pay_for`, `status`, `memo`, `create_time`, `changed_lasttime` FROM `payment` WHERE `id` = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "orderId", column = "order_id"),
            @Result(property = "payType", column = "pay_type"),
            @Result(property = "payTraceCode", column = "pay_trace_code"),
            @Result(property = "payFor", column = "pay_for"),
            @Result(property = "status", column = "status"),
            @Result(property = "memo", column = "memo"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "changedLasttime", column = "changed_lasttime")
    })
    PaymentEntity queryByKey(@Param("id") String id);

    @Insert("INSERT INTO `payment`(`id`, `user_id`, `order_id`, `pay_type`, `pay_trace_code`, `pay_for`, `status`, `memo`, `create_time`) VALUES(#{id}, #{userId}, #{orderId}, #{payType}, #{payTraceCode}, #{payFor}, #{status}, #{memo}, #{createTime})")
    void insert(PaymentEntity paymentEntity);

    @Update("UPDATE `payment` SET id=#{id}, user_id=#{userId}, order_id=#{orderId}, pay_type=#{payType}, pay_trace_code=#{payTraceCode}, pay_for=#{payFor}, status=#{status}, memo=#{memo}, create_time=#{createTime} WHERE `id` = #{id}")
    void update(PaymentEntity paymentEntity);

    @Delete("DELETE FROM `payment` WHERE `id` = #{id}")
    void delete(@Param("id") String id);

}