package com.q1e123.NetworkResourceMonitorWeb.model;

import java.sql.Date;

public class UserList {
    private int id;
    private String username;
    private java.sql.Date lastLogin;
    private int usageId;

    public UserList(int id, String username, Date lastLogin, int usageId) {
        this.id = id;
        this.username = username;
        this.lastLogin = lastLogin;
        this.usageId = usageId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public int getUsageId() {
        return usageId;
    }

    public void setUsageId(int usageId) {
        this.usageId = usageId;
    }
}
