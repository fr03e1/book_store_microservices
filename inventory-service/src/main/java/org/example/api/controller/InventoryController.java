package org.example.api.controller;

import org.example.constant.ApiConstant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiConstant.API_INVENTORY)
public class InventoryController {
    @GetMapping
    public String test() {
        return "Hello world";
    }
}
