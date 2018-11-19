package com.leshuibao.fragmentTax.dto.request;

import org.springframework.stereotype.Component;

@Component
public class ShoppingTrolleyDto {

    private String goodsName;
    private String goodsType;
    private String measureUnit;
    private Integer buyedNum;
    private float price;
    private float salesVolume;
    private float tax;
    private float taxAmount;

    public ShoppingTrolleyDto() {
    }

    public ShoppingTrolleyDto(String goodsName, String goodsType, String measureUnit, Integer buyedNum, float price, float salesVolume, float tax, float taxAmount) {
        this.goodsName = goodsName;
        this.goodsType = goodsType;
        this.measureUnit = measureUnit;
        this.buyedNum = buyedNum;
        this.price = price;
        this.salesVolume = salesVolume;
        this.tax = tax;
        this.taxAmount = taxAmount;
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
}
