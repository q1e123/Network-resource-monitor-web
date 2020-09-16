package com.q1e123.NetworkResourceMonitorWeb.model;

import java.sql.Date;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserList userList = (UserList) o;
        return id == userList.id &&
                usageId == userList.usageId &&
                Objects.equals(username, userList.username) &&
                Objects.equals(lastLogin, userList.lastLogin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, lastLogin, usageId);
    }
}
