package com.karthik.fd.user.controller;

import com.karthik.fd.user.model.UserProfile;
import com.karthik.fd.user.service.UserProfileService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user-profile")
public class UserProfileController {

    @Autowired
    private UserProfileService userProfileService;

    @PostMapping("/create")
    public ResponseEntity<?> createUserProfile(@Valid @RequestBody UserProfile userProfile) {
        return ResponseEntity.ok(userProfileService.createUserProfile(userProfile));
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateUser(@Valid @RequestBody UserProfile userProfile) {
        return ResponseEntity.ok(userProfileService.updateUserProfile(userProfile));
    }

}
