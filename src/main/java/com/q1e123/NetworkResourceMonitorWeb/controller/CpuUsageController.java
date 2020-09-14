package com.q1e123.NetworkResourceMonitorWeb.controller;

import com.q1e123.NetworkResourceMonitorWeb.model.CpuUsage;
import com.q1e123.NetworkResourceMonitorWeb.model.EnvironmentVariables;
import com.q1e123.NetworkResourceMonitorWeb.service.CpuUsageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CpuUsageController {
    @Autowired
    private CpuUsageService cpuUsageService;

    @GetMapping(path = "/cpu-usage-for/{usage-id}")
    public List<CpuUsage> get(@PathVariable("usage-id") int usageId) {
        return cpuUsageService.getCpuUsageFor(usageId);
    }
}
