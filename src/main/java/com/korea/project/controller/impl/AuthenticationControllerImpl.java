package com.korea.project.controller.impl;

import com.korea.project.entity.User;
import com.korea.project.models.LoginRequest;
import com.korea.project.models.LoginResponse;
import com.korea.project.models.SignupRequest;
import com.korea.project.repository.UserRepository;
import com.korea.project.service.impl.DAOUserDetailsService;
import com.korea.project.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.Random;

@RestController
public class AuthenticationControllerImpl {

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    DAOUserDetailsService daoUserDetailsService;
    @Autowired
    JwtUtil jwtUtil;
    @Autowired
    PasswordEncoder pwdEncoder;
    @Autowired
    UserRepository userRepository;

    @PostMapping("/auth/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        org.springframework.security.core.userdetails.User userDetails = (org.springframework.security.core.userdetails.User)authentication.getPrincipal();
        String jwt = jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new LoginResponse(userDetails.getUsername(), jwt));
    }

    @PostMapping("/auth/signup")
    public ResponseEntity<?> signupUser(@RequestBody SignupRequest signupRequest) {
        User user = new User();
        if(userRepository.existsUserEntityByUsername(signupRequest.getUsername())) {
            return ResponseEntity.ok("User already exists");
        }
        user.setUsername(signupRequest.getUsername());
        user.setPassword(pwdEncoder.encode(signupRequest.getUsername()));
        user.setFirstname(signupRequest.getFirstName());
        user.setLastname(signupRequest.getLastName());
        user.setJoindate(new Timestamp(System.currentTimeMillis()));
        if(signupRequest.getRole()==1) {
            user.setRole(1);
        } else {
            user.setRole(0);
        }
        user.setId((new Random()).nextInt());
        userRepository.save(user);
        return ResponseEntity.ok("User successfully created");
    }
}
