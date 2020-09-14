package com.q1e123.NetworkResourceMonitorWeb.controller;

import com.q1e123.NetworkResourceMonitorWeb.model.NetworkUsage;
import com.q1e123.NetworkResourceMonitorWeb.model.UserList;
import com.q1e123.NetworkResourceMonitorWeb.service.NetworkUsageService;
import com.q1e123.NetworkResourceMonitorWeb.service.UserListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserListController {
    @Autowired
    private UserListService userListService;

    @GetMapping(path = "/user-list-for/{usage-id}")
    public List<UserList> get(@PathVariable("usage-id") int usageId) {
        return userListService.getUserListFor(usageId);
    }
}
