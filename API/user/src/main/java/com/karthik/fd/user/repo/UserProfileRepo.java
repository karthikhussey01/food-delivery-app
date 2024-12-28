package com.karthik.fd.user.repo;

import com.karthik.fd.user.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepo extends JpaRepository<UserProfile, Integer> {
}
