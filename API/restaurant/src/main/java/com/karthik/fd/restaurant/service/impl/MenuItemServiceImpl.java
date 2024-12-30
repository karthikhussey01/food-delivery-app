package com.karthik.fd.restaurant.service.impl;

import com.karthik.fd.restaurant.model.MenuItem;
import com.karthik.fd.restaurant.repo.MenuItemRepo;
import com.karthik.fd.restaurant.service.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuItemServiceImpl implements MenuItemService {

    @Autowired
    private MenuItemRepo menuItemRepo;

    @Override
    public MenuItem createMenuItem(MenuItem menuItem) {
        return menuItemRepo.save(menuItem);
    }

    @Override
    public MenuItem updateMenuItem(MenuItem menuItem) {
        menuItemRepo.findById(menuItem.getId()).orElseThrow(() -> new IllegalArgumentException("Menu Item not found with ID " + menuItem.getId()));
        return menuItemRepo.save(menuItem);
    }
}
