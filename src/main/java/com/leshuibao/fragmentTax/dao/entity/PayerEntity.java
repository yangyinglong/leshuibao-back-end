package com.leshuibao.fragmentTax.dao.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;


@Entity
public class PayerEntity implements Serializable {

    @Id
    private String id;
    @Column
    private String payerCode;
    @Column
    private String payerName;
    @Column
    private String userId;
    @Column
    private String payerAddr;
    @Column
    private String payerPhone;
    @Column
    private String payerBank;
    @Column
    private String payerBankNo;
    @Column
    private Integer status;
    @Column
    private Integer payerType;
    @Column
    private String memo;
    @Column
    private String createTime;
    @Column
    private String changedLasttime;

    public PayerEntity() {
    }

    public PayerEntity(String id, String payerCode, String payerName, String userId, String payerAddr, String payerPhone, String payerBank, String payerBankNo, Integer status, Integer payerType, String memo, String createTime, String changedLasttime) {
        this.id = id;
        this.payerCode = payerCode;
        this.payerName = payerName;
        this.userId = userId;
        this.payerAddr = payerAddr;
        this.payerPhone = payerPhone;
        this.payerBank = payerBank;
        this.payerBankNo = payerBankNo;
        this.status = status;
        this.payerType = payerType;
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

    public String getPayerCode() {
        return payerCode;
    }

    public void setPayerCode(String payerCode) {
        this.payerCode = payerCode;
    }

    public String getPayerName() {
        return payerName;
    }

    public void setPayerName(String payerName) {
        this.payerName = payerName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPayerAddr() {
        return payerAddr;
    }

    public void setPayerAddr(String payerAddr) {
        this.payerAddr = payerAddr;
    }

    public String getPayerPhone() {
        return payerPhone;
    }

    public void setPayerPhone(String payerPhone) {
        this.payerPhone = payerPhone;
    }

    public String getPayerBank() {
        return payerBank;
    }

    public void setPayerBank(String payerBank) {
        this.payerBank = payerBank;
    }

    public String getPayerBankNo() {
        return payerBankNo;
    }

    public void setPayerBankNo(String payerBankNo) {
        this.payerBankNo = payerBankNo;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getPayerType() {
        return payerType;
    }

    public void setPayerType(Integer payerType) {
        this.payerType = payerType;
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