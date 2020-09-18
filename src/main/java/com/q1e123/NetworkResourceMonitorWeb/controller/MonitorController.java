package com.q1e123.NetworkResourceMonitorWeb.controller;

import com.q1e123.NetworkResourceMonitorWeb.Machine;
import com.q1e123.NetworkResourceMonitorWeb.model.EnvironmentVariables;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class MonitorController {
    @GetMapping(path = "/monitor/{machineId}")
    public String createPage(Model model, @PathVariable("machineId") String machineId) {
        Machine machine = new Machine(machineId);
        machine.build();
        model.addAttribute("machine", machine);

        return "monitor";
    }
}
