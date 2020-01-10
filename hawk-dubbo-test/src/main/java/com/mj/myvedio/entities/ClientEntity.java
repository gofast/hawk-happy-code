package com.mj.myvedio.entities;

import java.io.Serializable;
import java.util.List;

/**
 * 客户
 */
public class ClientEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private String uuid;

    private String name;

    private String remark;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
