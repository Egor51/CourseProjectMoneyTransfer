package com.app.transfermoney.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Confirmation {
    private Operation operationId;
    private String code;

    @JsonCreator
    public Confirmation(@JsonProperty("operationId") Operation operationId,
                                      @JsonProperty("code") String code) {
        this.operationId = operationId;
        this.code = code;
    }

    public Operation getOperationId() {
        return operationId;
    }

    public void setOperationId(Operation operationId) {
        this.operationId = operationId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
