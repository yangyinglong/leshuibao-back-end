package com.leshuibao.fragmentTax.dao.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;


@Entity
public class PaymentEntity implements Serializable {

    @Id
    private String id;
    @Column
    private String userId;
    @Column
    private String orderId;
    @Column
    private String payType;
    @Column
    private String payTraceCode;
    @Column
    private Integer payFor;
    @Column
    private Integer status;
    @Column
    private String memo;
    @Column
    private String createTime;
    @Column
    private String changedLasttime;

    public PaymentEntity() {
    }

    public PaymentEntity(String id, String userId, String orderId, String payType, String payTraceCode, Integer payFor, Integer status, String memo, String createTime, String changedLasttime) {
        this.id = id;
        this.userId = userId;
        this.orderId = orderId;
        this.payType = payType;
        this.payTraceCode = payTraceCode;
        this.payFor = payFor;
        this.status = status;
        this.memo = memo;
        this.createTime = createTime;
        this.changedLasttime = changedLasttime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getPayTraceCode() {
        return payTraceCode;
    }

    public void setPayTraceCode(String payTraceCode) {
        this.payTraceCode = payTraceCode;
    }

    public Integer getPayFor() {
        return payFor;
    }

    public void setPayFor(Integer payFor) {
        this.payFor = payFor;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getChangedLasttime() {
        return changedLasttime;
    }

    public void setChangedLasttime(String changedLasttime) {
        this.changedLasttime = changedLasttime;
    }

}