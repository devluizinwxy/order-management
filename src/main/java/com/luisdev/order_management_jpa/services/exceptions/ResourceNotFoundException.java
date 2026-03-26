package com.luisdev.order_management_jpa.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(Object id) {
        super("Resource not found. ID "+ id);
    }
}
