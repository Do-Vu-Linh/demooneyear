package com.spring.web.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {
    // Common
    BAD_REQUEST(HttpStatus.BAD_REQUEST.value(), "ECBR400", "Bad Request"),
    METHOD_ARGUMENT_TYPE_ENUM_BINDING_MISMATCH(HttpStatus.BAD_REQUEST.value(), "ECEBM400", "Bad Request (Method Argument Type Mismatch Error)"),
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED.value(), "ECU401", "Unauthorized"),
    FORBIDDEN(HttpStatus.FORBIDDEN.value(), "ECF403", "Forbidden"),
    NOT_FOUND(HttpStatus.NOT_FOUND.value(), "ECN404", "Not Found"),
    ;

    private final String code;
    private final String message;
    private int status;

    ErrorCode(final int status, final String code, final String message) {
        this.status = status;
        this.message = message;
        this.code = code;
    }
}
