package com.leshuibao.fragmentTax.dao.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;


@Entity
public class ShoppingTrolleyEntity implements Serializable {

    @Id
    private String id;
    @Column
    private String orderId;
    @Column
    private String goodsName;
    @Column
    private String goodsType;
    @Column
    private String measureUnit;
    @Column
    private Integer buyedNum;
    @Column
    private float price;
    @Column
    private float salesVolume;
    @Column
    private float tax;
    @Column
    private float taxAmount;
    @Column
    private Integer status;
    @Column
    private String memo;
    @Column
    private String createdTime;
    @Column
    private String changedLasttime;

    public ShoppingTrolleyEntity() {
    }

    public ShoppingTrolleyEntity(String id, String orderId, String goodsName, String goodsType, String measureUnit, Integer buyedNum, float price, float salesVolume, float tax, float taxAmount, Integer status, String memo, String createdTime, String changedLasttime) {
        this.id = id;
        this.orderId = orderId;
        this.goodsName = goodsName;
        this.goodsType = goodsType;
        this.measureUnit = measureUnit;
        this.buyedNum = buyedNum;
        this.price = price;
        this.salesVolume = salesVolume;
        this.tax = tax;
        this.taxAmount = taxAmount;
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

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }

    public String getMeasureUnit() {
        return measureUnit;
    }

    public void setMeasureUnit(String measureUnit) {
        this.measureUnit = measureUnit;
    }

    public Integer getBuyedNum() {
        return buyedNum;
    }

    public void setBuyedNum(Integer buyedNum) {
        this.buyedNum = buyedNum;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getSalesVolume() {
        return salesVolume;
    }

    public void setSalesVolume(float salesVolume) {
        this.salesVolume = salesVolume;
    }

    public float getTax() {
        return tax;
    }

    public void setTax(float tax) {
        this.tax = tax;
    }

    public float getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(float taxAmount) {
        this.taxAmount = taxAmount;
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