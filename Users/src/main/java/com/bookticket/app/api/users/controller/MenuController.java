package com.bookticket.app.api.users.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MenuController {

    @GetMapping("/menu")
    public String getMenu() {
        return "Menu";
    }
}
