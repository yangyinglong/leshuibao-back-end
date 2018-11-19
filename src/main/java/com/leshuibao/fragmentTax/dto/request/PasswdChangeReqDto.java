package com.leshuibao.fragmentTax.dto.request;

public class PasswdChangeReqDto {
    private String smsId;
    private String pass;
    private String phone;
    private String validatecode;

    public PasswdChangeReqDto(String smsId, String pass, String phone, String validatecode) {
        this.smsId = smsId;
        this.pass = pass;
        this.phone = phone;
        this.validatecode = validatecode;
    }

    public PasswdChangeReqDto() {
    }

    public String getValidatecode() {
        return validatecode;
    }

    public void setValidatecode(String validatecode) {
        this.validatecode = validatecode;
    }

    public String getSmsId() {
        return smsId;
    }

    public void setSmsId(String smsId) {
        this.smsId = smsId;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "PasswdChangeReqDto{" +
                "smsId='" + smsId + '\'' +
                ", pass='" + pass + '\'' +
                ", phone='" + phone + '\'' +
                ", validatecode='" + validatecode + '\'' +
                '}';
    }
}
