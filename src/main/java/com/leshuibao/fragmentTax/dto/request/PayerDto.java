package com.leshuibao.fragmentTax.dto.request;


import org.springframework.stereotype.Component;

@Component
public class PayerDto {

    private String payerName;
    private String payerCode;
    private String payerAddr;
    private String payerBank;
    private String payerPhone;
    private String payerMemo;
    private String payerBankNo;

    public PayerDto() {
    }

    public PayerDto(String payerName, String payerCode, String payerAddr, String payerBank, String payerPhone, String payerMemo, String payerBankNo) {
        this.payerName = payerName;
        this.payerCode = payerCode;
        this.payerAddr = payerAddr;
        this.payerBank = payerBank;
        this.payerPhone = payerPhone;
        this.payerMemo = payerMemo;
        this.payerBankNo = payerBankNo;
    }

    public String getPayerName() {
        return payerName;
    }

    public void setPayerName(String payerName) {
        this.payerName = payerName;
    }

    public String getPayerCode() {
        return payerCode;
    }

    public void setPayerCode(String payerCode) {
        this.payerCode = payerCode;
    }

    public String getPayerAddr() {
        return payerAddr;
    }

    public void setPayerAddr(String payerAddr) {
        this.payerAddr = payerAddr;
    }

    public String getPayerBank() {
        return payerBank;
    }

    public void setPayerBank(String payerBank) {
        this.payerBank = payerBank;
    }

    public String getPayerPhone() {
        return payerPhone;
    }

    public void setPayerPhone(String payerPhone) {
        this.payerPhone = payerPhone;
    }

    public String getPayerMemo() {
        return payerMemo;
    }

    public void setPayerMemo(String payerMemo) {
        this.payerMemo = payerMemo;
    }

    public String getPayerBankNo() {
        return payerBankNo;
    }

    public void setPayerBankNo(String payerBankNo) {
        this.payerBankNo = payerBankNo;
    }
}
