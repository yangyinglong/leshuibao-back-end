package com.leshuibao.fragmentTax.dao.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;


@Entity
public class OrderEntity implements Serializable {

    @Id
    private String id;
    @Column
    private String tradeName;  // 1-商业 2-工业 3-交通运输业 4-陆路运输业 5-装卸搬运业 6-建筑服务业 7-现代服务业 8-租赁业
    @Column
    private float taxRate;
    @Column
    private String payerId;
    @Column
    private String payeeId;
    @Column
    private String addressId;
    @Column
    private String expressCompany;  // 1-EMS 2-顺丰 3-中通 4-韵达 5-申通 6-百世汇通
    @Column
    private float expressFee;
    @Column
    private String expressTrackingCode;
    @Column
    private float totalAmount;
    @Column
    private float totalTaxAmount;
    @Column
    private Integer auditStatus;
    @Column
    private String auditer;
    @Column
    private String rejectReason;
    @Column
    private String RejectDesc;
    @Column
    private Integer status;
    @Column
    private String memo;
    @Column
    private String createdTime;
    @Column
    private String changedLasttime;

    public OrderEntity() {
    }

    public OrderEntity(String id, String tradeName, float taxRate, String payerId, String payeeId, String addressId, String expressCompany, float expressFee, String expressTrackingCode, float totalAmount, float totalTaxAmount, Integer auditStatus, String auditer, String rejectReason, String rejectDesc, Integer status, String memo, String createdTime, String changedLasttime) {
        this.id = id;
        this.tradeName = tradeName;
        this.taxRate = taxRate;
        this.payerId = payerId;
        this.payeeId = payeeId;
        this.addressId = addressId;
        this.expressCompany = expressCompany;
        this.expressFee = expressFee;
        this.expressTrackingCode = expressTrackingCode;
        this.totalAmount = totalAmount;
        this.totalTaxAmount = totalTaxAmount;
        this.auditStatus = auditStatus;
        this.auditer = auditer;
        this.rejectReason = rejectReason;
        RejectDesc = rejectDesc;
        this.status = status;
        this.memo = memo;
        this.createdTime = createdTime;
        this.changedLasttime = changedLasttime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRejectReason() {
        return rejectReason;
    }

    public void setRejectReason(String rejectReason) {
        this.rejectReason = rejectReason;
    }

    public String getRejectDesc() {
        return RejectDesc;
    }

    public void setRejectDesc(String rejectDesc) {
        RejectDesc = rejectDesc;
    }

    public String getTradeName() {
        return tradeName;
    }

    public void setTradeName(String tradeName) {
        this.tradeName = tradeName;
    }

    public float getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(float taxRate) {
        this.taxRate = taxRate;
    }

    public String getPayerId() {
        return payerId;
    }

    public void setPayerId(String payerId) {
        this.payerId = payerId;
    }

    public String getPayeeId() {
        return payeeId;
    }

    public void setPayeeId(String payeeId) {
        this.payeeId = payeeId;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getExpressCompany() {
        return expressCompany;
    }

    public void setExpressCompany(String expressCompany) {
        this.expressCompany = expressCompany;
    }

    public float getExpressFee() {
        return expressFee;
    }

    public void setExpressFee(float expressFee) {
        this.expressFee = expressFee;
    }

    public String getExpressTrackingCode() {
        return expressTrackingCode;
    }

    public void setExpressTrackingCode(String expressTrackingCode) {
        this.expressTrackingCode = expressTrackingCode;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public float getTotalTaxAmount() {
        return totalTaxAmount;
    }

    public void setTotalTaxAmount(float totalTaxAmount) {
        this.totalTaxAmount = totalTaxAmount;
    }

    public Integer getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getAuditer() {
        return auditer;
    }

    public void setAuditer(String auditer) {
        this.auditer = auditer;
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

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getChangedLasttime() {
        return changedLasttime;
    }

    public void setChangedLasttime(String changedLasttime) {
        this.changedLasttime = changedLasttime;
    }
}