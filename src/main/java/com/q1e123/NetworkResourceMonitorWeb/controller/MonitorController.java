package com.q1e123.NetworkResourceMonitorWeb.controller;

import com.q1e123.NetworkResourceMonitorWeb.Machine;
import com.q1e123.NetworkResourceMonitorWeb.model.*;
import com.q1e123.NetworkResourceMonitorWeb.service.*;
import com.q1e123.NetworkResourceMonitorWeb.utils.AuthenticationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class MonitorController {
    @Autowired
    private SystemService systemService;

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

    @GetMapping(path = "/monitor/{machineId}")
    public String createPage(Model model, @PathVariable("machineId") String machineId) {
        Systems system = systemService.getSystemWith(machineId);
        UsageData usageData = usageDataService.getUsageDataFor(system.getMachineId());
        int usageDataId = usageData.getId();
        List<CpuUsage> cpuUsageList = cpuUsageService.getCpuUsageFor(usageDataId);
        List<NetworkUsage> networkUsageList = networkUsageService.getNetworkUsageFor(usageDataId);
        List<EnvironmentVariables> environmentVariablesList = environmentVariablesService.getEnvironmentVariablesFor(usageDataId);
        List<UserList> userLists = userListService.getUserListFor(usageDataId);

        model.addAttribute("usageData", usageData);
        model.addAttribute("cpuUsageList", cpuUsageList);
        model.addAttribute("networkUsageList", networkUsageList);
        model.addAttribute("environmentVariablesList", environmentVariablesList);
        model.addAttribute("userLists", userLists);
        model.addAttribute("totalRam", usageData.getTotalRam());
        model.addAttribute("usedRam", usageData.getUsedRam());
        model.addAttribute("freeRam", usageData.getFreeRam());
        return "monitor";
    }


    @RequestMapping(value="/monitor/usageData/{machineId}", method= RequestMethod.GET)
    public String getUsageData(ModelMap map, @PathVariable("machineId") String machineId) {
        UsageData usageData = getUsageDataFromDatabase(machineId);
        map.addAttribute("usageData", usageData);

        return "monitor :: #usageData";
    }

    @RequestMapping(value="/monitor/ram/{machineId}", method= RequestMethod.GET)
    public String getRam(ModelMap map, @PathVariable("machineId") String machineId) {
        UsageData usageData = getUsageDataFromDatabase(machineId);
        map.addAttribute("totalRam", usageData.getTotalRam());
        map.addAttribute("usedRam", usageData.getUsedRam());
        map.addAttribute("freeRam", usageData.getFreeRam());

        return "monitor :: #ram";
    }

    private UsageData getUsageDataFromDatabase(String machineId){
        Systems system = systemService.getSystemWith(machineId);
        UsageData usageData = usageDataService.getUsageDataFor(system.getMachineId());
        return usageData;
    }

    @RequestMapping(value="/monitor/cpuUsageList/{machineId}", method= RequestMethod.GET)
    public String getCpuUsageList(ModelMap map, @PathVariable("machineId") String machineId) {
        int usageId = getUsageDataFromDatabase(machineId).getId();
        List<CpuUsage> cpuUsageList = cpuUsageService.getCpuUsageFor(usageId);
        map.addAttribute("cpuUsageList", cpuUsageList);

        return "monitor :: #cpuUsageList";
    }

    @RequestMapping(value="/monitor/networkUsageList/{machineId}", method= RequestMethod.GET)
    public String getNetworkUsageList(ModelMap map, @PathVariable("machineId") String machineId) {
        int usageId = getUsageDataFromDatabase(machineId).getId();
        List<NetworkUsage> networkUsageList = networkUsageService.getNetworkUsageFor(usageId);
        map.addAttribute("networkUsageList", networkUsageList);

        return "monitor :: #networkUsageList";
    }

    @RequestMapping(value="/monitor/userLists/{machineId}", method= RequestMethod.GET)
    public String getUserLists(ModelMap map, @PathVariable("machineId") String machineId) {
        int usageId = getUsageDataFromDatabase(machineId).getId();
        List<UserList> userLists = userListService.getUserListFor(usageId);
        map.addAttribute("userLists", userLists);

        return "monitor :: #userLists";
    }

    @RequestMapping(value="/monitor/environmentVariablesList/{machineId}", method= RequestMethod.GET)
    public String getEnvironmentVariablesList(ModelMap map, @PathVariable("machineId") String machineId) {
        int usageId = getUsageDataFromDatabase(machineId).getId();
        List<EnvironmentVariables> environmentVariablesList = environmentVariablesService.getEnvironmentVariablesFor(usageId);
        map.addAttribute("environmentVariablesList", environmentVariablesList);

        return "monitor :: #environmentVariablesList";
    }
}
