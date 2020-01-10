package com.mj.myvedio.entities;

import java.io.Serializable;

/**
 * 用户
 * @author mj
 */
public class UserEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 账户名称
     */
    private String userName;
    /**
     * 密码
     */
    private String password;
    /**
     * 所属客户
     */
    private String clientId;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }
}
