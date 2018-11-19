package com.leshuibao.fragmentTax.dto.request;

import org.springframework.stereotype.Component;

@Component
public class PayeeAddressReqDto {

    private Integer userId;
    private String address;
    private String expressCompany;

    public PayeeAddressReqDto() {
    }

    public PayeeAddressReqDto(Integer userId, String address, String expressCompany) {
        this.userId = userId;
        this.address = address;
        this.expressCompany = expressCompany;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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
}
