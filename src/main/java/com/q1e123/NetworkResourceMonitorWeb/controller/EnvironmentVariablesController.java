package com.q1e123.NetworkResourceMonitorWeb.controller;

import com.q1e123.NetworkResourceMonitorWeb.model.EnvironmentVariables;
import com.q1e123.NetworkResourceMonitorWeb.model.UsageData;
import com.q1e123.NetworkResourceMonitorWeb.service.EnvironmentVariablesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EnvironmentVariablesController {
    @Autowired
    private EnvironmentVariablesService environmentVariablesService;

    @GetMapping(path = "/environment-variables-for/{usage-id}")
    public List<EnvironmentVariables> get(@PathVariable("usage-id") int usageId) {
        return environmentVariablesService.getEnvironmentVariablesFor(usageId);
    }
}
