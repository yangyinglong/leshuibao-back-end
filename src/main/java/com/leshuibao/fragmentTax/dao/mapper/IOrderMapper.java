package com.leshuibao.fragmentTax.dao.mapper;

import com.leshuibao.fragmentTax.dao.entity.OrderEntity;
import org.apache.ibatis.annotations.*;

import java.util.Collection;
import java.util.List;


@Mapper
public interface IOrderMapper {
    @Select("SELECT `id`, `trade_name`, `tax_rate`, `payer_id`, `payee_id`, `address_id`, `express_company`, `express_fee`, `express_tracking_code`, `total_amount`, `total_tax_amout`, `audit_status`, `auditer`, `reject_reason`, `reject_desc`, `status`, `memo`, `created_time`, `changed_lasttime` FROM `order`")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "tradeName", column = "trade_name"),
            @Result(property = "taxRate", column = "tax_rate"),
            @Result(property = "payerId", column = "payer_id"),
            @Result(property = "payeeId", column = "payee_id"),
            @Result(property = "addressId", column = "address_id"),
            @Result(property = "expressCompany", column = "express_company"),
            @Result(property = "expressFee", column = "express_fee"),
            @Result(property = "expressTrackingCode", column = "express_tracking_code"),
            @Result(property = "totalAmount", column = "total_amount"),
            @Result(property = "totalTaxAmount", column = "total_tax_amout"),
            @Result(property = "auditStatus", column = "audit_status"),
            @Result(property = "auditer", column = "auditer"),
            @Result(property = "rejectReason", column = "reject_reason"),
            @Result(property = "rejectDesc", column = "reject_desc"),
            @Result(property = "status", column = "status"),
            @Result(property = "memo", column = "memo"),
            @Result(property = "createdTime", column = "created_time"),
            @Result(property = "changedLasttime", column = "changed_lasttime")
    })
    List<OrderEntity> queryAll();

    @Select("SELECT `id`, `trade_name`, `tax_rate`, `payer_id`, `payee_id`, `address_id`, `express_company`, `express_fee`, `express_tracking_code`, `total_amount`, `total_tax_amout`, `audit_status`, `auditer`, `reject_reason`, `reject_desc`, `status`, `memo`, `created_time`, `changed_lasttime` FROM `order` WHERE `id` = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "tradeName", column = "trade_name"),
            @Result(property = "taxRate", column = "tax_rate"),
            @Result(property = "payerId", column = "payer_id"),
            @Result(property = "payeeId", column = "payee_id"),
            @Result(property = "addressId", column = "address_id"),
            @Result(property = "expressCompany", column = "express_company"),
            @Result(property = "expressFee", column = "express_fee"),
            @Result(property = "expressTrackingCode", column = "express_tracking_code"),
            @Result(property = "totalAmount", column = "total_amount"),
            @Result(property = "totalTaxAmount", column = "total_tax_amout"),
            @Result(property = "auditStatus", column = "audit_status"),
            @Result(property = "auditer", column = "auditer"),
            @Result(property = "rejectReason", column = "reject_reason"),
            @Result(property = "rejectDesc", column = "reject_desc"),
            @Result(property = "status", column = "status"),
            @Result(property = "memo", column = "memo"),
            @Result(property = "createdTime", column = "created_time"),
            @Result(property = "changedLasttime", column = "changed_lasttime")
    })
    OrderEntity queryByKey(@Param("id") String id);

    @Insert("INSERT INTO `order`(`id`, `trade_name`, `tax_rate`, `payer_id`, `payee_id`, `address_id`, `express_company`, `express_fee`, `express_tracking_code`, `total_amount`, `total_tax_amout`, `audit_status`, `auditer`, `reject_reason`, `reject_desc`, `status`, `memo`, `created_time`) VALUES(#{id}, #{tradeName}, #{taxRate}, #{payerId}, #{payeeId}, #{addressId}, #{expressCompany}, #{expressFee}, #{expressTrackingCode}, #{totalAmount},#{totalTaxAmount}, #{auditStatus}, #{auditer}, #{rejectReason}, #{rejectDesc}, #{status}, #{memo}, #{createdTime})")
    void insert(OrderEntity orderEntity);

    @Update("UPDATE `order` SET trade_name=#{tradeName}, tax_rate=#{taxRate}, payer_id=#{payerId}, payee_id=#{payeeId}, address_id=#{addressId}, express_company=#{expressCompany}, express_fee=#{expressFee}, express_tracking_code=#{expressTrackingCode}, total_amount=#{totalAmount},total_tax_amout=#{totalTaxAmount}, memo=#{memo}, reject_reason=#{rejectReason}, reject_desc=#{rejectDesc} WHERE `id` = #{id}")
    void update(OrderEntity orderEntity);

    @Update("UPDATE `order` SET reject_reason=#{rejectReason}, reject_desc=#{rejectDesc}, express_tracking_code=#{rejectReason}, audit_status=#{auditStatus} WHERE `id` = #{id}")
    void updateReject(@Param("id") String id, @Param("rejectReason") String rejectReason, @Param("rejectDesc") String rejectDesc, @Param("auditStatus") Integer auditStatus);

    @Update("UPDATE `order` SET express_company=#{expressCompany}, express_tracking_code=#{expressTrackingCode}, reject_reason='', audit_status=#{auditStatus} WHERE `id` = #{id}")
    void updateExpress(@Param("id") String id, @Param("expressCompany") String expressCompany, @Param("expressTrackingCode") String expressTrackingCode,@Param("auditStatus") Integer auditStatus);

    @Update("UPDATE `order` SET audit_status=#{auditStatus}, auditer=#{auditer}, status=#{status}, memo=#{memo}, reject_reason=#{rejectReason}, reject_desc=#{rejectDesc} WHERE `id` = #{id}")
    void updateForAudit(OrderEntity orderEntity);

    @Delete("DELETE FROM `order` WHERE `id` = #{id}")
    void delete(@Param("id") String id);

    @Select("SELECT `id`, `trade_name`, `tax_rate`, `payer_id`, `payee_id`, `address_id`, `express_company`, `express_fee`, `express_tracking_code`, `total_amount`, `total_tax_amout`, `audit_status`, `auditer`, `status`, `memo`, `created_time`, `changed_lasttime`, `reject_reason`, `reject_desc`" +
            "FROM `order` where `payee_id` = #{payeeId} and `audit_status` in " +
            "(${auditStatus})" +
            "order by `changed_lasttime`")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "tradeName", column = "trade_name"),
            @Result(property = "taxRate", column = "tax_rate"),
            @Result(property = "payerId", column = "payer_id"),
            @Result(property = "payeeId", column = "payee_id"),
            @Result(property = "addressId", column = "address_id"),
            @Result(property = "expressCompany", column = "express_company"),
            @Result(property = "expressFee", column = "express_fee"),
            @Result(property = "expressTrackingCode", column = "express_tracking_code"),
            @Result(property = "totalAmount", column = "total_amount"),
            @Result(property = "totalTaxAmount", column = "total_tax_amout"),
            @Result(property = "auditStatus", column = "audit_status"),
            @Result(property = "auditer", column = "auditer"),
            @Result(property = "rejectReason", column = "reject_reason"),
            @Result(property = "rejectDesc", column = "reject_desc"),
            @Result(property = "status", column = "status"),
            @Result(property = "memo", column = "memo"),
            @Result(property = "createdTime", column = "created_time"),
            @Result(property = "changedLasttime", column = "changed_lasttime")
    })
    List<OrderEntity> queryByC1(@Param("payeeId") String payeeId, @Param("auditStatus") String auditStatus, @Param("startNum") Integer startNum, @Param("pageRange") Integer pageRange);

    @Update("UPDATE `order` SET status=#{status} WHERE `id` = #{id}")
    void updateStatusById(@Param("id") String orderId, @Param("status") int status);
}