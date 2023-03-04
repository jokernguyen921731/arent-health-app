package com.argent.health.app.service;

import com.argent.health.app.web.rest.request.user.UserCreateRequest;
import com.argent.health.app.web.rest.request.user.UserLoginRequest;

import javax.servlet.http.HttpServletRequest;

public interface UserAccountService {
    Void create(UserCreateRequest request);
}
