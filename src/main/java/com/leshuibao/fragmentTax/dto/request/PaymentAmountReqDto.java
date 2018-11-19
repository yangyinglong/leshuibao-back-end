package com.leshuibao.fragmentTax.dto.request;

public class PaymentAmountReqDto {

    private String orderId;
    private float shouldPayAmount;
    private String payTraceCode;

    public PaymentAmountReqDto() {
    }

    public PaymentAmountReqDto(String orderId, float shouldPayAmount, String payTraceCode) {
        this.orderId = orderId;
        this.shouldPayAmount = shouldPayAmount;
        this.payTraceCode = payTraceCode;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public float getShouldPayAmount() {
        return shouldPayAmount;
    }

    public void setShouldPayAmount(float shouldPayAmount) {
        this.shouldPayAmount = shouldPayAmount;
    }

    public String getPayTraceCode() {
        return payTraceCode;
    }

    public void setPayTraceCode(String payTraceCode) {
        this.payTraceCode = payTraceCode;
    }
}
