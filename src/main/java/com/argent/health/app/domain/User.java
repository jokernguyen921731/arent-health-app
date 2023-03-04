package com.argent.health.app.domain;

import lombok.*;

import java.time.Instant;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class User {
    private UUID userId;
    private String username;
    private String fullName;
    private String phoneNumber;
    private String email;
    private String address;
    private Instant expiredAt;
    private Instant availableAt;
}
