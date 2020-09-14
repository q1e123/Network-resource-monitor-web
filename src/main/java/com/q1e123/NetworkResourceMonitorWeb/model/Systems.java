package com.q1e123.NetworkResourceMonitorWeb.model;

public class Systems {
    private int id;
    private int systemStatus;
    private String machineId;

    public Systems(int id, int systemStatus, String machineId) {
        this.id = id;
        this.systemStatus = systemStatus;
        this.machineId = machineId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSystemStatus() {
        return systemStatus;
    }

    public void setSystemStatus(int systemStatus) {
        this.systemStatus = systemStatus;
    }

    public String getMachineID() {
        return machineId;
    }

    public void setMachineID(String machineId) {
        this.machineId = machineId;
    }
}
