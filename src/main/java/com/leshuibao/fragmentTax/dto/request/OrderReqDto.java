package com.leshuibao.fragmentTax.dto.request;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderReqDto {

    private String userId;
    private String tradeName;
    private float taxRate;
    private PayerDto payerDto;
    private String payeeId;
    private List<ShoppingTrolleyDto> shoppingTrolleyDtos;
    private String address;
    private String expressCompany;
    private float totalAmount;
    private float totalTaxAmount;
    private float expressFee;

    public OrderReqDto() {
    }

    public OrderReqDto(String userId, String tradeName, float taxRate, PayerDto payerDto, String payeeId, List<ShoppingTrolleyDto> shoppingTrolleyDtos, String address, String expressCompany, float totalAmount, float totalTaxAmount, float expressFee) {
        this.userId = userId;
        this.tradeName = tradeName;
        this.taxRate = taxRate;
        this.payerDto = payerDto;
        this.payeeId = payeeId;
        this.shoppingTrolleyDtos = shoppingTrolleyDtos;
        this.address = address;
        this.expressCompany = expressCompany;
        this.totalAmount = totalAmount;
        this.totalTaxAmount = totalTaxAmount;
        this.expressFee = expressFee;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTradeName() {
        return tradeName;
    }

    public void setTradeName(String tradeName) {
        this.tradeName = tradeName;
    }

    public float getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(float taxRate) {
        this.taxRate = taxRate;
    }

    public PayerDto getPayerDto() {
        return payerDto;
    }

    public void setPayerDto(PayerDto payerDto) {
        this.payerDto = payerDto;
    }

    public String getPayeeId() {
        return payeeId;
    }

    public void setPayeeId(String payeeId) {
        this.payeeId = payeeId;
    }

    public List<ShoppingTrolleyDto> getShoppingTrolleyDtos() {
        return shoppingTrolleyDtos;
    }

    public void setShoppingTrolleyDtos(List<ShoppingTrolleyDto> shoppingTrolleyDtos) {
        this.shoppingTrolleyDtos = shoppingTrolleyDtos;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getExpressCompany() {
        return expressCompany;
    }

    public void setExpressCompany(String expressCompany) {
        this.expressCompany = expressCompany;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public float getTotalTaxAmount() {
        return totalTaxAmount;
    }

    public void setTotalTaxAmount(float totalTaxAmount) {
        this.totalTaxAmount = totalTaxAmount;
    }

    public float getExpressFee() {
        return expressFee;
    }

    public void setExpressFee(float expressFee) {
        this.expressFee = expressFee;
    }
}
