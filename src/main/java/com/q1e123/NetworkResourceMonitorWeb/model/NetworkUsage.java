package com.q1e123.NetworkResourceMonitorWeb.model;

public class NetworkUsage {
    private int id;
    private String interfaceName;
    private double rx;
    private double tx;
    private String ipv4;
    private int usageId;

    public NetworkUsage(int id, String interfaceName, double rx, double tx, String ipv4, int usageId) {
        this.id = id;
        this.interfaceName = interfaceName;
        this.rx = rx;
        this.tx = tx;
        this.ipv4 = ipv4;
        this.usageId = usageId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public double getRx() {
        return rx;
    }

    public void setRx(double rx) {
        this.rx = rx;
    }

    public double getTx() {
        return tx;
    }

    public void setTx(double tx) {
        this.tx = tx;
    }

    public String getIpv4() {
        return ipv4;
    }

    public void setIpv4(String ipv4) {
        this.ipv4 = ipv4;
    }

    public int getUsageId() {
        return usageId;
    }

    public void setUsageId(int usageId) {
        this.usageId = usageId;
    }
}
