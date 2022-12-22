package com.app.transfermoney.exception;

public class InputDataError extends RuntimeException {
    public InputDataError(String msg) {
        super(msg);
    }
}
