package com.q1e123.NetworkResourceMonitorWeb.controller;

import com.q1e123.NetworkResourceMonitorWeb.model.*;
import com.q1e123.NetworkResourceMonitorWeb.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import com.q1e123.NetworkResourceMonitorWeb.utils.AuthenticationUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class MyMachineController {
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

    @GetMapping("/my-machine")
    public String createPage(Model model) {
        String username = AuthenticationUtils.getCurrentUsername();
        Systems system = systemService.getSystemFor(username);

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

        return "my-machine";
    }

    @RequestMapping(value="/usageData", method= RequestMethod.GET)
    public String getUsageData(ModelMap map) {
        UsageData usageData = getUsageDataFromDatabase();
        map.addAttribute("usageData", usageData);

        return "my-machine :: #usageData";
    }

    @RequestMapping(value="/ram", method= RequestMethod.GET)
    public String getRam(ModelMap map) {
        UsageData usageData = getUsageDataFromDatabase();
        map.addAttribute("totalRam", usageData.getTotalRam());
        map.addAttribute("usedRam", usageData.getUsedRam());
        map.addAttribute("freeRam", usageData.getFreeRam());

        return "my-machine :: #ram";
    }

    private UsageData getUsageDataFromDatabase(){
        String username = AuthenticationUtils.getCurrentUsername();
        Systems system = systemService.getSystemFor(username);
        UsageData usageData = usageDataService.getUsageDataFor(system.getMachineId());
        return usageData;
    }

    @RequestMapping(value="/cpuUsageList", method= RequestMethod.GET)
    public String getCpuUsageList(ModelMap map) {
        int usageId = getUsageDataFromDatabase().getId();
        List<CpuUsage> cpuUsageList = cpuUsageService.getCpuUsageFor(usageId);
        map.addAttribute("cpuUsageList", cpuUsageList);

        return "my-machine :: #cpuUsageList";
    }

    @RequestMapping(value="/networkUsageList", method= RequestMethod.GET)
    public String getNetworkUsageList(ModelMap map) {
        int usageId = getUsageDataFromDatabase().getId();
        List<NetworkUsage> networkUsageList = networkUsageService.getNetworkUsageFor(usageId);
        map.addAttribute("networkUsageList", networkUsageList);

        return "my-machine :: #networkUsageList";
    }

    @RequestMapping(value="/userLists", method= RequestMethod.GET)
    public String getUserLists(ModelMap map) {
        int usageId = getUsageDataFromDatabase().getId();
        List<UserList> userLists = userListService.getUserListFor(usageId);
        map.addAttribute("userLists", userLists);

        return "my-machine :: #userLists";
    }

    @RequestMapping(value="/environmentVariablesList", method= RequestMethod.GET)
    public String getEnvironmentVariablesList(ModelMap map) {
        int usageId = getUsageDataFromDatabase().getId();
        List<EnvironmentVariables> environmentVariablesList = environmentVariablesService.getEnvironmentVariablesFor(usageId);
        map.addAttribute("environmentVariablesList", environmentVariablesList);

        return "my-machine :: #environmentVariablesList";
    }

}
