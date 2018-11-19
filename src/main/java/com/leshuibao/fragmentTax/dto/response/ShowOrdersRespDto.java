package com.leshuibao.fragmentTax.dto.response;

public class ShowOrdersRespDto {

    private String orderId;
    private String createdTime;
    private String payeeName;
    private float totalAmount;
    private String auditStatus;
    private String expressCompany;
    private String expressTrackingCode;

    public ShowOrdersRespDto() {
    }

    public ShowOrdersRespDto(String orderId, String createdTime, String payeeName, float totalAmount, String auditStatus, String expressCompany, String expressTrackingCode) {
        this.orderId = orderId;
        this.createdTime = createdTime;
        this.payeeName = payeeName;
        this.totalAmount = totalAmount;
        this.auditStatus = auditStatus;
        this.expressCompany = expressCompany;
        this.expressTrackingCode = expressTrackingCode;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getPayeeName() {
        return payeeName;
    }

    public void setPayeeName(String payeeName) {
        this.payeeName = payeeName;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getExpressCompany() {
        return expressCompany;
    }

    public void setExpressCompany(String expressCompany) {
        this.expressCompany = expressCompany;
    }

    public String getExpressTrackingCode() {
        return expressTrackingCode;
    }

    public void setExpressTrackingCode(String expressTrackingCode) {
        this.expressTrackingCode = expressTrackingCode;
    }
}
