package com.karthik.fd.restaurant.service;

import com.karthik.fd.restaurant.model.MenuItem;
import com.karthik.fd.restaurant.model.Restaurant;

import java.util.List;
import java.util.Optional;

public interface RestaurantService {

    List<Restaurant> getAllRestaurants();

    Optional<Restaurant> getRestaurant(Integer id);

    List<MenuItem> getRestaurantMenu(Integer id);

    Restaurant createRestaurant(Restaurant restaurant);

    Restaurant updateRestaurant(Restaurant restaurant);
}
