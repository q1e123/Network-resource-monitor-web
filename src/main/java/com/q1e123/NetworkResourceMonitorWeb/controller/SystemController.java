package com.q1e123.NetworkResourceMonitorWeb.controller;

import com.q1e123.NetworkResourceMonitorWeb.model.Systems;
import com.q1e123.NetworkResourceMonitorWeb.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SystemController {
    @Autowired
    private SystemService systemService;

    @GetMapping(path = "/allsystems")
    public List<Systems> getAllSystems(){
        return systemService.getAllSystems();
    }
}
