package com.leshuibao.fragmentTax.dto.request;

public class PassInvoiceReqDto {
    private String orderId;
    private String expressCompany;
    private String expressTrackingCode;

    public PassInvoiceReqDto(String orderId, String expressCompany, String expressTrackingCode) {
        this.orderId = orderId;
        this.expressCompany = expressCompany;
        this.expressTrackingCode = expressTrackingCode;
    }

    public PassInvoiceReqDto() {
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
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
