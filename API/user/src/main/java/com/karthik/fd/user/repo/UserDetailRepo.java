package com.karthik.fd.user.repo;

import com.karthik.fd.user.model.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDetailRepo extends JpaRepository<UserDetail, Integer> {
    Optional<UserDetail> findByUsername(String username);
}
