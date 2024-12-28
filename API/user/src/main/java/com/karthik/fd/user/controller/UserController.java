package com.karthik.fd.user.controller;

import com.karthik.fd.user.model.UserDetail;
import com.karthik.fd.user.service.JwtService;
import com.karthik.fd.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@Valid @RequestBody UserDetail userDetail) {
        return ResponseEntity.ok(userService.createUser(userDetail));
    }

    @PostMapping("/validate")
    public ResponseEntity<?> validateUser(@Valid @RequestBody UserDetail userDetail) {
        return ResponseEntity.ok(userService.validateUser(userDetail));
    }

}
