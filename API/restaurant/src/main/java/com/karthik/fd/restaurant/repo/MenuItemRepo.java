package com.karthik.fd.restaurant.repo;

import com.karthik.fd.restaurant.model.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuItemRepo extends JpaRepository<MenuItem, Integer> {
}
