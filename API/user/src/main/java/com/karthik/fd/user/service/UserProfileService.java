package com.karthik.fd.user.service;

import com.karthik.fd.user.model.UserProfile;

public interface UserProfileService {

    UserProfile createUserProfile(UserProfile userProfile);

    UserProfile updateUserProfile(UserProfile userProfile);

}
