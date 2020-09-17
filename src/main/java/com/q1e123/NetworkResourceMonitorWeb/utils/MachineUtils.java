package com.q1e123.NetworkResourceMonitorWeb.utils;

import com.q1e123.NetworkResourceMonitorWeb.Machine;
import com.q1e123.NetworkResourceMonitorWeb.model.Systems;
import com.q1e123.NetworkResourceMonitorWeb.service.SystemService;

import java.util.ArrayList;
import java.util.List;

public class MachineUtils {
    static public List<Machine> getActiveMachines(){
        SystemService systemService = new SystemService();
        List<Systems> activeSystemList = systemService.getActiveSystems();
        List<Machine> machineList = new ArrayList<>();
        for (Systems systems : activeSystemList){
            Machine machine = new Machine(systems.getMachineId());
            machine.build();
            machineList.add(machine);
        }
        return machineList;
    }
}
