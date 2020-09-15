package com.q1e123.NetworkResourceMonitorWeb.controller;

import com.q1e123.NetworkResourceMonitorWeb.model.Systems;
import com.q1e123.NetworkResourceMonitorWeb.service.SystemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddNewSystem {
    @GetMapping("/add-new-system")
    public String addNewUserForm(Model model) {
        model.addAttribute("systems", new Systems());
        return "add-new-system";
    }

    @PostMapping("/add-new-system")
    public void addNewUserSubmit(@ModelAttribute Systems systems, Model model) {
        SystemService systemService = new SystemService();
        systemService.insertSystems(systems);
    }
}
