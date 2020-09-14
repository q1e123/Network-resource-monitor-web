package com.q1e123.NetworkResourceMonitorWeb.model;

public class CpuUsage {
    private int id;
    private String cpuName;
    private double cpuUsage;
    private int usageId;

    public CpuUsage(int id, String cpuName, double cpuUsage, int usageId) {
        this.id = id;
        this.cpuName = cpuName;
        this.cpuUsage = cpuUsage;
        this.usageId = usageId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpuName() {
        return cpuName;
    }

    public void setCpuName(String cpuName) {
        this.cpuName = cpuName;
    }

    public double getCpuUsage() {
        return cpuUsage;
    }

    public void setCpuUsage(double cpuUsage) {
        this.cpuUsage = cpuUsage;
    }

    public int getUsageId() {
        return usageId;
    }

    public void setUsageId(int usageId) {
        this.usageId = usageId;
    }
}
