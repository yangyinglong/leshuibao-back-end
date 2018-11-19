package com.leshuibao.fragmentTax.dao.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;


@Entity
public class PayeeEntity implements Serializable {

    @Id
    private String id;
    @Column
    private String payeeName;
    @Column
    private String payeeCidno;
    @Column
    private String payeeCidUrl;
    @Column
    private Integer payeeType;
    @Column
    private String userId;
    @Column
    private Integer status;
    @Column
    private String memo;
    @Column
    private String createdTime;
    @Column
    private String changedLasttime;

    public PayeeEntity() {
    }

    public PayeeEntity(String id, String payeeName, String payeeCidno, String payeeCidUrl, Integer payeeType, String userId, Integer status, String memo, String createdTime, String changedLasttime) {
        this.id = id;
        this.payeeName = payeeName;
        this.payeeCidno = payeeCidno;
        this.payeeCidUrl = payeeCidUrl;
        this.payeeType = payeeType;
        this.userId = userId;
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

    public String getPayeeName() {
        return payeeName;
    }

    public void setPayeeName(String payeeName) {
        this.payeeName = payeeName;
    }

    public String getPayeeCidno() {
        return payeeCidno;
    }

    public void setPayeeCidno(String payeeCidno) {
        this.payeeCidno = payeeCidno;
    }

    public String getPayeeCidUrl() {
        return payeeCidUrl;
    }

    public void setPayeeCidUrl(String payeeCidUrl) {
        this.payeeCidUrl = payeeCidUrl;
    }

    public Integer getPayeeType() {
        return payeeType;
    }

    public void setPayeeType(Integer payeeType) {
        this.payeeType = payeeType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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