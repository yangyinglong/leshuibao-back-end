package com.leshuibao.fragmentTax.dto.request;

public class PayeeEditReqDto {
    private String userId;
    private String payeeName;
    private String cidno;
    private String oldCidno;
    private String cidUrl;
    private String oldName;


    public PayeeEditReqDto() {
    }

    public PayeeEditReqDto(String userId, String payeeName, String cidno, String oldCidno, String cidUrl, String oldName) {
        this.userId = userId;
        this.payeeName = payeeName;
        this.cidno = cidno;
        this.oldCidno = oldCidno;
        this.cidUrl = cidUrl;
        this.oldName = oldName;
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

    public String getOldCidno() {
        return oldCidno;
    }

    public void setOldCidno(String oldCidno) {
        this.oldCidno = oldCidno;
    }

    public String getCidUrl() {
        return cidUrl;
    }

    public void setCidUrl(String cidUrl) {
        this.cidUrl = cidUrl;
    }

    public String getOldName() {
        return oldName;
    }

    public void setOldName(String oldName) {
        this.oldName = oldName;
    }
}
