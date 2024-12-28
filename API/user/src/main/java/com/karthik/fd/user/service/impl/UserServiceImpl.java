package com.karthik.fd.user.service.impl;

import com.karthik.fd.user.model.UserDetail;
import com.karthik.fd.user.model.UserProfile;
import com.karthik.fd.user.repo.UserDetailRepo;
import com.karthik.fd.user.service.JwtService;
import com.karthik.fd.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDetailRepo userDetailRepo;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @Transactional
    @Override
    public String createUser(UserDetail userDetail) {
        userDetail.setPassword(passwordEncoder.encode(userDetail.getPassword()));
        if (userDetail.getUserProfile() == null) {
            throw new IllegalArgumentException("User profile should not be null");
        }
        UserProfile profile = userDetail.getUserProfile();
        profile.setUserDetail(userDetail);
        userDetail = userDetailRepo.save(userDetail);
        return jwtService.generateToken(userDetail);
    }

    @Override
    public String validateUser(UserDetail userDetail) {
        Optional<UserDetail> optionalUser = userDetailRepo.findByUsername(userDetail.getUsername());
        if (optionalUser.isEmpty()) {
            throw new IllegalArgumentException("User not found with username " + userDetail.getUsername());
        }
        if (!passwordEncoder.matches(userDetail.getPassword(), optionalUser.get().getPassword())) {
            throw new IllegalArgumentException("Password Wrong for the user " + userDetail.getUsername());
        }
        return jwtService.generateToken(optionalUser.get());
    }

}
