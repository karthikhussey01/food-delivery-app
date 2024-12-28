package com.karthik.fd.user.service;

import com.karthik.fd.user.model.UserDetail;

public interface JwtService {

    String generateToken(UserDetail userDetail);

}
