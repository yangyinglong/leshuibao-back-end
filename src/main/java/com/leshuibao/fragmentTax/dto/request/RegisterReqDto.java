package com.leshuibao.fragmentTax.dto.request;

import org.springframework.stereotype.Component;

@Component
public class RegisterReqDto {

    private String username;
    private String phone;
    private String password;
    private String smsCode;
    private String smsId;

    public RegisterReqDto() {
    }

    public RegisterReqDto(String username, String phone, String password, String smsCode, String smsId) {
        this.username = username;
        this.phone = phone;
        this.password = password;
        this.smsCode = smsCode;
        this.smsId = smsId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSmsCode() {
        return smsCode;
    }

    public void setSmsCode(String smsCode) {
        this.smsCode = smsCode;
    }

    public String getSmsId() {
        return smsId;
    }

    public void setSmsId(String smsId) {
        this.smsId = smsId;
    }
}
