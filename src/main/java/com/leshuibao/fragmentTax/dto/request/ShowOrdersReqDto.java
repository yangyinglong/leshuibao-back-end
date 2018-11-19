package com.leshuibao.fragmentTax.dto.request;

public class ShowOrdersReqDto {

    private String userId;
    private String[] auditStatus;
    private Integer startPageNum;
    private Integer pageRange;

    public ShowOrdersReqDto() {
    }

    public ShowOrdersReqDto(String userId, String[] auditStatus, Integer startPageNum, Integer pageRange) {
        this.userId = userId;
        this.auditStatus = auditStatus;
        this.startPageNum = startPageNum;
        this.pageRange = pageRange;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String[] getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String[] auditStatus) {
        this.auditStatus = auditStatus;
    }

    public Integer getStartPageNum() {
        return startPageNum;
    }

    public void setStartPageNum(Integer startPageNum) {
        this.startPageNum = startPageNum;
    }

    public Integer getPageRange() {
        return pageRange;
    }

    public void setPageRange(Integer pageRange) {
        this.pageRange = pageRange;
    }
}
