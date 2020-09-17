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

    @Autowired
    private CpuUsageService cpuUsageService;

    @Autowired
    private EnvironmentVariablesService environmentVariablesService;

    @Autowired
    private NetworkUsageService networkUsageService;

    @Autowired
    private UsageDataService usageDataService;

    @Autowired
    private UserListService userListService;

    public Machine(String machineId){
        this.machineId = machineId;
    }

    public void build(){
        usageData = usageDataService.getUsageDataFor(machineId);
        int usageDataId = usageData.getId();
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
