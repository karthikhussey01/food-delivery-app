package com.karthik.fd.user.service.impl;

import com.karthik.fd.user.model.UserProfile;
import com.karthik.fd.user.repo.UserProfileRepo;
import com.karthik.fd.user.service.UserProfileService;
import org.springframework.stereotype.Service;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    private UserProfileRepo userProfileRepo;

    @Override
    public UserProfile createUserProfile(UserProfile userProfile) {
        return userProfileRepo.save(userProfile);
    }

    @Override
    public UserProfile updateUserProfile(UserProfile userProfile) {
        userProfileRepo.findById(userProfile.getId()).orElseThrow(() -> new IllegalArgumentException("User Profile not found with ID " + userProfile.getId()));
        return userProfileRepo.save(userProfile);
    }
}
