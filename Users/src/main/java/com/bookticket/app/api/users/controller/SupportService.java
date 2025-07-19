package com.bookticket.app.api.users.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SupportService {
    @GetMapping("/support")
    public String getMenu() {
        return "Support";
    }
}
