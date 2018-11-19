package com.leshuibao.fragmentTax.dao.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;


@Entity
public class RoleAuthorityEntity implements Serializable {

    @Id
    private String id;
    @Column
    private String roleId;
    @Column
    private String authorityId;
    @Column
    private Integer status;
    @Column
    private String memo;
    @Column
    private String createdTime;
    @Column
    private String changedLasttime;

    public RoleAuthorityEntity() {
    }

    public RoleAuthorityEntity(String id, String roleId, String authorityId, Integer status, String memo, String createdTime, String changedLasttime) {
        this.id = id;
        this.roleId = roleId;
        this.authorityId = authorityId;
        this.status = status;
        this.memo = memo;
        this.createdTime = createdTime;
        this.changedLasttime = changedLasttime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getAuthorityId() {
        return authorityId;
    }

    public void setAuthorityId(String authorityId) {
        this.authorityId = authorityId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getChangedLasttime() {
        return changedLasttime;
    }

    public void setChangedLasttime(String changedLasttime) {
        this.changedLasttime = changedLasttime;
    }

}