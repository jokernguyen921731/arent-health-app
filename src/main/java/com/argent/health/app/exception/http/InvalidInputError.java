package com.argent.health.app.exception.http;

import com.vsm.vin.common.misc.exception.http.ResponseError;
import lombok.Getter;

@Getter
public enum InvalidInputError implements ResponseError {
    FOOD_RECORD_EXIST(4004000, "FOOD_RECORD_EXIST"),
    EXERCISE_RECORD_EXIST(4004001, "EXERCISE_RECORD_EXIST"),
    ;
    private Integer code;
    private String message;

    InvalidInputError(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getName() {
        return name();
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public int getStatus() {
        return 400;
    }

    public Integer getCode() {
        return code;
    }
}
