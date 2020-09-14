package com.q1e123.NetworkResourceMonitorWeb.controller;

import com.q1e123.NetworkResourceMonitorWeb.model.EnvironmentVariables;
import com.q1e123.NetworkResourceMonitorWeb.model.NetworkUsage;
import com.q1e123.NetworkResourceMonitorWeb.service.EnvironmentVariablesService;
import com.q1e123.NetworkResourceMonitorWeb.service.NetworkUsageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NetworkUsageController {
    @Autowired
    private NetworkUsageService networkUsageService;

    @GetMapping(path = "/network-usage-for/{usage-id}")
    public List<NetworkUsage> get(@PathVariable("usage-id") int usageId) {
        return networkUsageService.getNetworkUsageFor(usageId);
    }
}
