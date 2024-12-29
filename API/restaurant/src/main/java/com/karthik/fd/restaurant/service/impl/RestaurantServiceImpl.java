package com.karthik.fd.restaurant.service.impl;

import com.karthik.fd.restaurant.model.MenuItem;
import com.karthik.fd.restaurant.model.Restaurant;
import com.karthik.fd.restaurant.repo.RestaurantRepo;
import com.karthik.fd.restaurant.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepo restaurantRepo;

    @Override
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepo.findAll();
    }

    @Override
    public Optional<Restaurant> getRestaurant(Integer id) {
        return restaurantRepo.findById(id);
    }

    @Override
    public List<MenuItem> getRestaurantMenu(Integer id) {
        return restaurantRepo.findById(id).map(Restaurant :: getMenuItems).orElse(null);
    }

    @Override
    public Restaurant createRestaurant(Restaurant restaurant) {
        return restaurantRepo.save(restaurant);
    }

    @Override
    public Restaurant updateRestaurant(Restaurant restaurant) {
        restaurantRepo.findById(restaurant.getId()).orElseThrow(() -> new IllegalArgumentException("Restaurant not found with ID " + restaurant.getId()));
        return restaurantRepo.save(restaurant);
    }

}
