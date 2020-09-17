package com.q1e123.NetworkResourceMonitorWeb;

import com.q1e123.NetworkResourceMonitorWeb.model.*;
import com.q1e123.NetworkResourceMonitorWeb.service.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Machine {
    private String machineId;

    private UsageData usageData;
    private List<CpuUsage> cpuUsageList;
    private List<EnvironmentVariables> environmentVariablesList;
    private List<NetworkUsage> networkUsageList;
    private List<UserList> userLists;

    private CpuUsageService cpuUsageService;
    private EnvironmentVariablesService environmentVariablesService;
    private NetworkUsageService networkUsageService;
    private UsageDataService usageDataService;
    private UserListService userListService;

    public Machine(String machineId){
        this.machineId = machineId;
        cpuUsageService = new CpuUsageService();
        environmentVariablesService = new EnvironmentVariablesService();
        networkUsageService = new NetworkUsageService();
        usageDataService = new UsageDataService();
        userListService = new UserListService();
    }

    public void build(){
        System.out.println("build");
        System.out.println("ID: " + machineId);
        usageData = usageDataService.getUsageDataFor(machineId);
        int usageDataId = usageData.getId();
        System.out.println("Usage ID: " + usageDataId);
        cpuUsageList = cpuUsageService.getCpuUsageFor(usageDataId);
        environmentVariablesList = environmentVariablesService.getEnvironmentVariablesFor(usageDataId);
        networkUsageList = networkUsageService.getNetworkUsageFor(usageDataId);
        userLists = userListService.getUserListFor(usageDataId);
    }

    public String getMachineId() {
        return machineId;
    }

    public UsageData getUsageData() {
        return usageData;
    }

    public List<CpuUsage> getCpuUsageList() {
        return cpuUsageList;
    }

    public List<EnvironmentVariables> getEnvironmentVariablesList() {
        return environmentVariablesList;
    }

    public List<NetworkUsage> getNetworkUsageList() {
        return networkUsageList;
    }

    public List<UserList> getUserLists() {
        return userLists;
    }

    public CpuUsageService getCpuUsageService() {
        return cpuUsageService;
    }

    public EnvironmentVariablesService getEnvironmentVariablesService() {
        return environmentVariablesService;
    }

    public NetworkUsageService getNetworkUsageService() {
        return networkUsageService;
    }

    public UsageDataService getUsageDataService() {
        return usageDataService;
    }

    public UserListService getUserListService() {
        return userListService;
    }
}
