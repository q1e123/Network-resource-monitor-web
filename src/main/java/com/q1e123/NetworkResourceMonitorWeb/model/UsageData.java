package com.q1e123.NetworkResourceMonitorWeb.model;

import java.sql.Date;
import java.util.List;

public class UsageData {
    private int id;
    private int totalRam;
    private int usedRam;
    private int freeRam;
    private double avalabileSpace;
    private java.sql.Date usageTimestamp;
    private String username;
    private String operatingSystem;
    private List<String> programList;
    private int systemId;

    public UsageData(int id, int totalRam, int usedRam, int freeRam, double avalabileSpace, Date usageTimestamp, String username, String operatingSystem, List<String> programList, int systemId) {
        this.id = id;
        this.totalRam = totalRam;
        this.usedRam = usedRam;
        this.freeRam = freeRam;
        this.avalabileSpace = avalabileSpace;
        this.usageTimestamp = usageTimestamp;
        this.username = username;
        this.operatingSystem = operatingSystem;
        this.programList = programList;
        this.systemId = systemId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotalRam() {
        return totalRam;
    }

    public void setTotalRam(int totalRam) {
        this.totalRam = totalRam;
    }

    public int getUsedRam() {
        return usedRam;
    }

    public void setUsedRam(int usedRam) {
        this.usedRam = usedRam;
    }

    public int getFreeRam() {
        return freeRam;
    }

    public void setFreeRam(int freeRam) {
        this.freeRam = freeRam;
    }

    public double getAvalabileSpace() {
        return avalabileSpace;
    }

    public void setAvalabileSpace(double avalabileSpace) {
        this.avalabileSpace = avalabileSpace;
    }

    public Date getUsageTimestamp() {
        return usageTimestamp;
    }

    public void setUsageTimestamp(Date usageTimestamp) {
        this.usageTimestamp = usageTimestamp;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public List<String> getProgramList() {
        return programList;
    }

    public void setProgramList(List<String> programList) {
        this.programList = programList;
    }

    public int getSystemId() {
        return systemId;
    }

    public void setSystemId(int systemId) {
        this.systemId = systemId;
    }

    @Override
    public String toString() {
        return "UsageData{" +
                "id=" + id +
                ", totalRam=" + totalRam +
                ", usedRam=" + usedRam +
                ", freeRam=" + freeRam +
                ", avalabileSpace=" + avalabileSpace +
                ", usageTimestamp=" + usageTimestamp +
                ", username='" + username + '\'' +
                ", operatingSystem='" + operatingSystem + '\'' +
                ", programList=" + programList +
                ", systemId=" + systemId +
                '}';
    }
}
