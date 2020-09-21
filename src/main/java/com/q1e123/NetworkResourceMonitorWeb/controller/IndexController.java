package com.q1e123.NetworkResourceMonitorWeb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping(path = "/")
    public String createPage(){
        return "index.html";
    }
}
