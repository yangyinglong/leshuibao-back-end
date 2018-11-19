package com.leshuibao.fragmentTax.dto.request;

import com.leshuibao.fragmentTax.dao.entity.AddressEntity;
import com.leshuibao.fragmentTax.dao.entity.PayerEntity;
import com.leshuibao.fragmentTax.dao.entity.ShoppingTrolleyEntity;

import java.util.List;

public class OrderEditReqDto {

    private String orderId;
    private String tradeName;
    private float taxRate;
    private PayerEntity payerEntity;
    private String payeeId;
    private List<ShoppingTrolleyEntity> shoppingTrolleyEntitys;
    private AddressEntity addressEntity;
    private String expressCompany;
    private String totalAmount;
    private String totalTaxAmount;
    private String expressFee;

    public OrderEditReqDto() {
    }

    public OrderEditReqDto(String orderId, String tradeName, float taxRate, PayerEntity payerEntity, String payeeId, List<ShoppingTrolleyEntity> shoppingTrolleyEntitys, AddressEntity addressEntity, String expressCompany, String totalAmount, String totalTaxAmount, String expressFee) {
        this.orderId = orderId;
        this.tradeName = tradeName;
        this.taxRate = taxRate;
        this.payerEntity = payerEntity;
        this.payeeId = payeeId;
        this.shoppingTrolleyEntitys = shoppingTrolleyEntitys;
        this.addressEntity = addressEntity;
        this.expressCompany = expressCompany;
        this.totalAmount = totalAmount;
        this.totalTaxAmount = totalTaxAmount;
        this.expressFee = expressFee;
    }

    public float getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(float taxRate) {
        this.taxRate = taxRate;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getTradeName() {
        return tradeName;
    }

    public void setTradeName(String tradeName) {
        this.tradeName = tradeName;
    }

    public PayerEntity getPayerEntity() {
        return payerEntity;
    }

    public void setPayerEntity(PayerEntity payerEntity) {
        this.payerEntity = payerEntity;
    }

    public String getPayeeId() {
        return payeeId;
    }

    public void setPayeeId(String payeeId) {
        this.payeeId = payeeId;
    }

    public List<ShoppingTrolleyEntity> getShoppingTrolleyEntitys() {
        return shoppingTrolleyEntitys;
    }

    public void setShoppingTrolleyEntitys(List<ShoppingTrolleyEntity> shoppingTrolleyEntitys) {
        this.shoppingTrolleyEntitys = shoppingTrolleyEntitys;
    }

    public AddressEntity getAddressEntity() {
        return addressEntity;
    }

    public void setAddressEntity(AddressEntity addressEntity) {
        this.addressEntity = addressEntity;
    }

    public String getExpressCompany() {
        return expressCompany;
    }

    public void setExpressCompany(String expressCompany) {
        this.expressCompany = expressCompany;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getTotalTaxAmount() {
        return totalTaxAmount;
    }

    public void setTotalTaxAmount(String totalTaxAmount) {
        this.totalTaxAmount = totalTaxAmount;
    }

    public String getExpressFee() {
        return expressFee;
    }

    public void setExpressFee(String expressFee) {
        this.expressFee = expressFee;
    }
}
