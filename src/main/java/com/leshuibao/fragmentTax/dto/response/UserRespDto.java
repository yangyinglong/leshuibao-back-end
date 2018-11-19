package com.leshuibao.fragmentTax.dto.response;

import org.springframework.stereotype.Component;

@Component
public class UserRespDto {

    private String userId;
    private String userName;
    private String phone;
    private Integer status;
    private String createTime;

    public UserRespDto() {
    }

    public UserRespDto(String userId, String userName, String phone, Integer status, String createTime) {
        this.userId = userId;
        this.userName = userName;
        this.phone = phone;
        this.status = status;
        this.createTime = createTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
