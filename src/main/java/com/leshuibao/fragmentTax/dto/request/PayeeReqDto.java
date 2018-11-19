package com.leshuibao.fragmentTax.dto.request;


import org.springframework.stereotype.Component;

@Component
public class PayeeReqDto {

    private String userId;
    private String payeeName;
    private String cidno;
    private String cid_url;

    public PayeeReqDto() {
    }

    public PayeeReqDto(String userId, String payeeName, String cidno, String cid_url) {
        this.userId = userId;
        this.payeeName = payeeName;
        this.cidno = cidno;
        this.cid_url = cid_url;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPayeeName() {
        return payeeName;
    }

    public void setPayeeName(String payeeName) {
        this.payeeName = payeeName;
    }

    public String getCidno() {
        return cidno;
    }

    public void setCidno(String cidno) {
        this.cidno = cidno;
    }

    public String getCid_url() {
        return cid_url;
    }

    public void setCid_url(String cid_url) {
        this.cid_url = cid_url;
    }
}
