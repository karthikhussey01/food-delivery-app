package com.karthik.fd.restaurant.controller;

import com.karthik.fd.restaurant.model.MenuItem;
import com.karthik.fd.restaurant.service.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuItemService menuItemService;

    @PostMapping
    public ResponseEntity<?> createMenuItem(@RequestBody MenuItem menuItem) {
        return ResponseEntity.ok(menuItemService.createMenuItem(menuItem));
    }

    @PutMapping
    public ResponseEntity<?> updateMenuItem(@RequestBody MenuItem menuItem) {
        return ResponseEntity.ok(menuItemService.updateMenuItem(menuItem));
    }
}
