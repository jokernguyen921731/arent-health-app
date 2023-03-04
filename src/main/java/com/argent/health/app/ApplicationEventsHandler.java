package com.argent.health.app;

import com.argent.health.app.config.AppProperties;
import com.argent.health.app.entity.UserEntity;
import com.argent.health.app.enums.IdentityType;
import com.argent.health.app.enums.Role;
import com.argent.health.app.service.UserAccountService;
import com.argent.health.app.web.rest.request.user.UserCreateRequest;
import com.argent.health.app.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
@Slf4j
public class ApplicationEventsHandler {
    private final AppProperties appProperties;
    private final UserRepository userRepository;
    private final UserAccountService userService;

    public ApplicationEventsHandler(AppProperties appProperties,
                                    UserRepository userRepository,
                                    UserAccountService userService) {
        this.appProperties = appProperties;
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void onStartup() {
        log.info("===== Application startup =====");
        createRootUser();
        log.info("===== Finish application startup =====");
    }

    @Transactional
    public void createRootUser() {
        AppProperties.RootUser rootUser = appProperties.getAuth().getRootUser();

        Optional<UserEntity> userEntity = userRepository.findByUsernameAndIdentityProviderType(rootUser.getUsername(), IdentityType.LOCAL);
        if (userEntity.isEmpty()) {
            userService.create(UserCreateRequest.builder().username(rootUser.getUsername())
                    .password(rootUser.getPassword())
                    .fullName(rootUser.getFullname())
                    .email(rootUser.getEmail())
                    .phoneNumber(rootUser.getPhoneNumber())
                    .identityType(IdentityType.LOCAL)
                    .role(Role.ADMIN)
                    .build());
            log.info("Initialized root user: " + rootUser.getUsername());
        } else {
            log.info("Root user existed: " + rootUser.getUsername());
        }
    }
}
