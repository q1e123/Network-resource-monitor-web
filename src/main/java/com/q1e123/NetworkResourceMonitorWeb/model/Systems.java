package com.q1e123.NetworkResourceMonitorWeb.model;

public class Systems {
    private Integer id;
    private Integer systemStatus;
    private String machineId;

    public Systems(int id, int systemStatus, String machineId) {
        this.id = id;
        this.systemStatus = systemStatus;
        this.machineId = machineId;
    }

    public Systems(){
        this.id = null;
        this.systemStatus = null;
        this.machineId = null;
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

    public String getMachineId() {
        return machineId;
    }

    public void setMachineId(String machineId) {
        this.machineId = machineId;
    }

    @Override
    public String toString() {
        return "Systems{" +
                "id=" + id +
                ", systemStatus=" + systemStatus +
                ", machineId='" + machineId + '\'' +
                '}';
    }

    public String systemStatusString(){
        return this.systemStatus.toString();
    }
}
