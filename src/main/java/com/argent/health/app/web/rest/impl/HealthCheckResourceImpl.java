package com.argent.health.app.web.rest.impl;

import com.argent.health.app.web.rest.response.ServiceResponse;
import com.argent.health.app.web.rest.HealthCheckResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HealthCheckResourceImpl implements HealthCheckResource {
    @Override
    public ServiceResponse search() {
        return ServiceResponse.succeed(HttpStatus.OK, "OK");
    }
}
