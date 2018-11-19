package com.leshuibao.fragmentTax.dto.request;


import org.springframework.stereotype.Component;

@Component
public class PaymentDto {

    private String userId;
    private String orderId;
    private String payType;
    private float payAmount;
    private String payCode;
    private Integer payFor;

    public PaymentDto() {
    }

    public PaymentDto(String userId, String orderId, String payType, float payAmount, String payCode, Integer payFor) {
        this.userId = userId;
        this.orderId = orderId;
        this.payType = payType;
        this.payAmount = payAmount;
        this.payCode = payCode;
        this.payFor = payFor;
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

    public float getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(float payAmount) {
        this.payAmount = payAmount;
    }

    public String getPayCode() {
        return payCode;
    }

    public void setPayCode(String payCode) {
        this.payCode = payCode;
    }

    public Integer getPayFor() {
        return payFor;
    }

    public void setPayFor(Integer payFor) {
        this.payFor = payFor;
    }
}
