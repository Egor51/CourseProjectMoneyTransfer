package com.app.transfermoney.exception;

public class TransferError extends RuntimeException {
    public TransferError(String msg) {
        super(msg);
    }
}

