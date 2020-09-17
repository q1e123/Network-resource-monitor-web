package com.q1e123.NetworkResourceMonitorWeb.controller;

import com.q1e123.NetworkResourceMonitorWeb.Machine;
import com.q1e123.NetworkResourceMonitorWeb.model.CpuUsage;
import com.q1e123.NetworkResourceMonitorWeb.model.Systems;
import com.q1e123.NetworkResourceMonitorWeb.service.SystemService;
import com.q1e123.NetworkResourceMonitorWeb.utils.MachineUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class RealTimeController {

    @GetMapping("/real-time")
    public String createPage(Model model) {

        List<Machine> machineList = MachineUtils.getActiveMachines();
        model.addAttribute("machineList", machineList);
        return "real-time";
    }

    @RequestMapping(value="/machineList", method= RequestMethod.GET)
    public String getCpuUsageList(ModelMap map) {
        List<Machine> machineList = MachineUtils.getActiveMachines();
        map.addAttribute("machineList", machineList);

        return "real-time :: #machineList";
    }
}
