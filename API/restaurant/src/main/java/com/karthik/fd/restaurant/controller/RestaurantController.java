package com.karthik.fd.restaurant.controller;

import com.karthik.fd.restaurant.model.Restaurant;
import com.karthik.fd.restaurant.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping
    public ResponseEntity<?> getAllRestaurants() {
        return ResponseEntity.ok(restaurantService.getAllRestaurants());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getRestaurant(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(restaurantService.getRestaurant(id).orElse(null));
    }

    @GetMapping("/{id}/menu")
    public ResponseEntity<?> getRestaurantMenu(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(restaurantService.getRestaurantMenu(id));
    }

    @PostMapping
    public ResponseEntity<?> createRestaurant(@RequestBody Restaurant restaurant) {
        return ResponseEntity.ok(restaurantService.createRestaurant(restaurant));
    }

    @PutMapping
    public ResponseEntity<?> updateRestaurant(@RequestBody Restaurant restaurant) {
        return ResponseEntity.ok(restaurantService.updateRestaurant(restaurant));
    }
}
