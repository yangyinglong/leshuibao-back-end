package com.leshuibao.fragmentTax.dto.request;

public class PayeeDeleteReqDto {
    private String userId;
    private String cidno;

    public PayeeDeleteReqDto() {
    }

    public PayeeDeleteReqDto(String userId, String cidno) {
        this.userId = userId;
        this.cidno = cidno;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCidno() {
        return cidno;
    }

    public void setCidno(String cidno) {
        this.cidno = cidno;
    }
}