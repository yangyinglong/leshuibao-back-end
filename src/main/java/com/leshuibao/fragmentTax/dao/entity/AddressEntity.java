package com.leshuibao.fragmentTax.dao.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;


@Entity
public class AddressEntity implements Serializable {

    @Id
    private String id;
    @Column
    private String address;
    @Column
    private String addresseeId;
    @Column
    private Integer addresseeType;
    @Column
    private Integer status;
    @Column
    private String memo;
    @Column
    private String createdTime;
    @Column
    private String changedLasttime;

    public AddressEntity() {
    }

    public AddressEntity(String id, String address, String addresseeId, Integer addresseeType, Integer status, String memo, String createdTime, String changedLasttime) {
        this.id = id;
        this.address = address;
        this.addresseeId = addresseeId;
        this.addresseeType = addresseeType;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddresseeId() {
        return addresseeId;
    }

    public void setAddresseeId(String addresseeId) {
        this.addresseeId = addresseeId;
    }

    public Integer getAddresseeType() {
        return addresseeType;
    }

    public void setAddresseeType(Integer addresseeType) {
        this.addresseeType = addresseeType;
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