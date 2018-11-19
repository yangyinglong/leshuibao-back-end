package com.leshuibao.fragmentTax.dto.request;

public class RejectReasonReqDto {
    private String id;      // 订单id
    private String reason;  // 驳回原因
    private String desc;    // 驳回明细

    public RejectReasonReqDto() {
    }

    public RejectReasonReqDto(String id, String reason, String desc) {
        this.id = id;
        this.reason = reason;
        this.desc = desc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
