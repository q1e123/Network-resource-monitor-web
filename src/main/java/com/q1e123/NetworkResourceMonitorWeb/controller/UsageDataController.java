package com.q1e123.NetworkResourceMonitorWeb.controller;

import com.q1e123.NetworkResourceMonitorWeb.model.UsageData;
import com.q1e123.NetworkResourceMonitorWeb.service.UsageDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsageDataController {
    @Autowired
    private UsageDataService usageDataService;

    @GetMapping(path = "/usage-data-for/{machine-id}")
    public UsageData getUsageDatafor(@PathVariable("machine-id") String machineId) {
        return usageDataService.getUsageDataFor(machineId);
    }
}
