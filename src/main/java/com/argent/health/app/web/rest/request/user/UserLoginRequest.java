package com.argent.health.app.web.rest.request.user;

import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
@Valid
public class UserLoginRequest {
    @NotBlank(message = "USERNAME_REQUIRED")
    private String username;
    @NotBlank(message = "PASSWORD_REQUIRED")
    private String password;

//    private IdentityType identityType;
}
