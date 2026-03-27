package com.luisdev.order_management_jpa.resource.exceptions;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidationErrorHandler extends StandardError {
    private List<FieldMessage> errors = new ArrayList<>();

    public ValidationErrorHandler() {
    }

    public ValidationErrorHandler(Instant timestamp, Integer status, String error, String message, String path) {
        super(timestamp, status, error, message, path);
    }

    public List<FieldMessage> getErrors() {
        return errors;
    }

    public void addErrors(String field, String message) {
        errors.add(new FieldMessage(field,message));
    }
}
