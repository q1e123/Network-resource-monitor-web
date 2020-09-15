package com.q1e123.NetworkResourceMonitorWeb.controller;

import com.q1e123.NetworkResourceMonitorWeb.model.Systems;
import com.q1e123.NetworkResourceMonitorWeb.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SystemManagementController {
    @Autowired
    private SystemService systemService;

    @GetMapping("/system-management")
    public String createPage(Model model) {
        model.addAttribute("systems", new Systems());
        model.addAttribute("systemList", systemService.getAllSystems());
        return "system-management";
    }

    @PostMapping("/add-new-system")
    public String addNewSystemSubmit(@ModelAttribute Systems systems, Model model) {
        systemService.insertSystems(systems);
        model.addAttribute("systems", new Systems());
        model.addAttribute("systemList", systemService.getAllSystems());
        return "system-management";
    }

    @PostMapping("/update-system")
    public String updateSystemSubmit(@ModelAttribute Systems systems, Model model) {
        systemService.updateSystem(systems);
        model.addAttribute("systems", new Systems());
        model.addAttribute("systemList", systemService.getAllSystems());
        return "system-management";
    }
}
