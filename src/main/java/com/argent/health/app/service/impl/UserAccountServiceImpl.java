package com.argent.health.app.service.impl;

import com.argent.health.app.entity.*;
import com.argent.health.app.repository.*;
import com.argent.health.app.enums.UserStatus;
import com.argent.health.app.service.UserAccountService;
import com.argent.health.app.web.rest.request.user.UserCreateRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Slf4j
public class UserAccountServiceImpl implements UserAccountService {

    private final UserRepository userRepository;
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserAccountServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Void create(UserCreateRequest request) {
        userRepository.save(UserEntity.builder().userId(UUID.randomUUID())
                .username(request.getUsername())
                .password(this.passwordEncoder.encode(request.getPassword()))
                .fullName(request.getFullName())
                .phoneNumber(request.getPhoneNumber())
                .email(request.getEmail())
                .role(request.getRole())
                .identityType(request.getIdentityType())
                .userStatus(UserStatus.ACTIVE)
                .build());
        return null;
    }
}
