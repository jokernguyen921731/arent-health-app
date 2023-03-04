package com.argent.health.app.exception.http;

import com.vsm.vin.common.misc.exception.http.ResponseError;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum NotFoundError implements ResponseError {
    USER_NOT_FOUND(4044000, "USER_NOT_FOUND"),
    FOOD_RECORD_NOT_FOUND(4044001, "FOOD_RECORD_NOT_FOUND"),
    EXERCISE_RECORD_NOT_FOUND(4044002, "EXERCISE_RECORD_NOT_FOUND"),
    ;


    private int errorCode;
    private String message;

    NotFoundError(int errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    @Override
    public String getName() {
        return this.name();
    }

    public int getStatus() {
        return HttpStatus.NOT_FOUND.value();
    }

    @Override
    public Integer getCode() {
        return errorCode;
    }
}
