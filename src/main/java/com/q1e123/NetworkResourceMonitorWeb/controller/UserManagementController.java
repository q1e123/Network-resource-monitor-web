package com.q1e123.NetworkResourceMonitorWeb.controller;

import com.q1e123.NetworkResourceMonitorWeb.model.Systems;
import com.q1e123.NetworkResourceMonitorWeb.model.Users;
import com.q1e123.NetworkResourceMonitorWeb.service.SystemService;
import com.q1e123.NetworkResourceMonitorWeb.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserManagementController {
    @Autowired
    private UsersService usersService;

    @GetMapping("/user-management")
    public String createPage(Model model) {
        model.addAttribute("users", new Users());
        model.addAttribute("userList", usersService.getAllUsers());
        return "user-management";
    }

    @PostMapping("/add-new-user")
    public String addNewSystemSubmit(@ModelAttribute Users users, Model model) {
        usersService.insertUser(users);
        model.addAttribute("users", new Users());
        model.addAttribute("userList", usersService.getAllUsers());
        return "user-management";
    }

    @PostMapping("/update-user")
    public String updateSystemSubmit(@ModelAttribute Users users, Model model) {
        usersService.updateUser(users);
        model.addAttribute("users", new Users());
        model.addAttribute("userList", usersService.getAllUsers());
        return "user-management";
    }

}
