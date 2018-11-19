package com.leshuibao.fragmentTax.dao.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;


@Entity
public class InvoiceDeliveryEntity implements Serializable {

    @Id
    private String id;
    @Column
    private String userId;
    @Column
    private String addressId;
    @Column
    private String expressCompany;
    @Column
    private String auditorId;
    @Column
    private String auditerStatus;
    @Column
    private Integer status;
    @Column
    private String createdTime;
    @Column
    private String changedLasttime;

    public InvoiceDeliveryEntity() {
    }

    public InvoiceDeliveryEntity(String id, String userId, String addressId, String expressCompany, String auditorId, String auditerStatus, Integer status, String createdTime, String changedLasttime) {
        this.id = id;
        this.userId = userId;
        this.addressId = addressId;
        this.expressCompany = expressCompany;
        this.auditorId = auditorId;
        this.auditerStatus = auditerStatus;
        this.status = status;
        this.createdTime = createdTime;
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

    public String getAuditorId() {
        return auditorId;
    }

    public void setAuditorId(String auditorId) {
        this.auditorId = auditorId;
    }

    public String getAuditerStatus() {
        return auditerStatus;
    }

    public void setAuditerStatus(String auditerStatus) {
        this.auditerStatus = auditerStatus;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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