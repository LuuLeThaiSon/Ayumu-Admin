package com.example.ayumuadmin.exception;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AyumuException extends Exception {
    private String statusCode;
    private String message;

    public AyumuException(String message, String statusCode) {
        super(message);
        this.statusCode = statusCode;
        this.message = message;
    }

    public AyumuException(String message, Throwable cause, String statusCode) {
        super(message, cause);
        this.statusCode = statusCode;
        this.message = message;
    }

    public AyumuException(Throwable cause, String statusCode, String message) {
        super(cause);
        this.statusCode = statusCode;
        this.message = message;
    }

    public AyumuException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String statusCode) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.statusCode = statusCode;
        this.message = message;
    }
}
