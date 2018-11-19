package com.leshuibao.fragmentTax.dto.request;

public class PayReqDto {
    private String orderId;
    private double allAmount;

    public PayReqDto(String orderId, double allAmount) {
        this.orderId = orderId;
        this.allAmount = allAmount;
    }

    public PayReqDto() {
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public double getAllAmount() {
        return allAmount;
    }

    public void setAllAmount(double allAmount) {
        this.allAmount = allAmount;
    }

}
