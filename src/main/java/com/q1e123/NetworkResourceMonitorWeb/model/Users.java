package com.q1e123.NetworkResourceMonitorWeb.model;

public class Users {
    private int id;
    private String username;
    private int userRole;
    private int systemId;

    public Users(int id, String username, int userRole, int systemId) {
        this.id = id;
        this.username = username;
        this.userRole = userRole;
        this.systemId = systemId;
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

    public int getUserRole() {
        return userRole;
    }

    public void setUserRole(int userRole) {
        this.userRole = userRole;
    }

    public int getSystemId() {
        return systemId;
    }

    public void setSystemId(int systemId) {
        this.systemId = systemId;
    }
}
