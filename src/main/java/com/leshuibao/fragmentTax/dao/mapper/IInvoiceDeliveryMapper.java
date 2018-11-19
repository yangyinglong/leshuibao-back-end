package com.leshuibao.fragmentTax.dao.mapper;

import com.leshuibao.fragmentTax.dao.entity.InvoiceDeliveryEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface IInvoiceDeliveryMapper {
    @Select("SELECT `id`, `user_id`, `address_id`, `express_company`, `auditor_id`, `auditer_status`, `status`, `created_time`, `changed_lasttime` FROM `invoice_delivery`")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "addressId", column = "address_id"),
            @Result(property = "expressCompany", column = "express_company"),
            @Result(property = "auditorId", column = "auditor_id"),
            @Result(property = "auditerStatus", column = "auditer_status"),
            @Result(property = "status", column = "status"),
            @Result(property = "createdTime", column = "created_time"),
            @Result(property = "changedLasttime", column = "changed_lasttime")
    })
    List<InvoiceDeliveryEntity> queryAll();

    @Select("SELECT `id`, `user_id`, `address_id`, `express_company`, `auditor_id`, `auditer_status`, `status`, `created_time`, `changed_lasttime` FROM `invoice_delivery` WHERE `id` = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "addressId", column = "address_id"),
            @Result(property = "expressCompany", column = "express_company"),
            @Result(property = "auditorId", column = "auditor_id"),
            @Result(property = "auditerStatus", column = "auditer_status"),
            @Result(property = "status", column = "status"),
            @Result(property = "createdTime", column = "created_time"),
            @Result(property = "changedLasttime", column = "changed_lasttime")
    })
    InvoiceDeliveryEntity queryByKey(@Param("id") String id);

    @Insert("INSERT INTO `invoice_delivery`(`id`, `user_id`, `address_id`, `express_company`, `auditor_id`, `auditer_status`, `status`, `created_time`) VALUES(#{id}, #{userId}, #{addressId}, #{expressCompany}, #{auditorId}, #{auditerStatus}, #{status}, #{createdTime})")
    void insert(InvoiceDeliveryEntity invoice_deliveryEntity);

    @Update("UPDATE `invoice_delivery` SET id=#{id}, user_id=#{userId}, address_id=#{addressId}, express_company=#{expressCompany}, auditor_id=#{auditorId}, auditer_status=#{auditerStatus}, status=#{status}, created_time=#{createdTime} WHERE `id` = #{id}")
    void update(InvoiceDeliveryEntity invoice_deliveryEntity);

    @Delete("DELETE FROM `invoice_delivery` WHERE `id` = #{id}")
    void delete(@Param("id") String id);

}