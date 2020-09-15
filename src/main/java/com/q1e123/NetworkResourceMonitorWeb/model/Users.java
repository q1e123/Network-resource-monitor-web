package com.q1e123.NetworkResourceMonitorWeb.model;

import org.apache.catalina.User;

public class Users {
    private Integer id;
    private String username;
    private Integer userRole;
    private Integer systemId;

    public Users(int id, String username, int userRole, int systemId) {
        this.id = id;
        this.username = username;
        this.userRole = userRole;
        this.systemId = systemId;
    }

    public Users(){
        this.id = null;
        this.username = null;
        this.userRole = null;
        this.systemId = null;
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

    public Integer getUserRole() {
        return userRole;
    }

    public void setUserRole(Integer userRole) {
        this.userRole = userRole;
    }

    public Integer getSystemId() {
        return systemId;
    }

    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", userRole=" + userRole +
                ", systemId=" + systemId +
                '}';
    }
}
