package com.karthik.fd.user.service;

import com.karthik.fd.user.model.UserDetail;
import jakarta.validation.Valid;

public interface UserService {

    String createUser(UserDetail userDetail);


    String validateUser(@Valid UserDetail userDetail);
}
