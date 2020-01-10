package com.mj.myvedio.entities;

import java.io.Serializable;

/**
 * 账户
 * @author mj
 */
public class AccountEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 账户名称
     */
    private String account;

    /**
     * 账户类型：微信账户，支付宝账户，
     */
    private String type;
    /**
     * 所属客户
     */
    private String clientId;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }
}
