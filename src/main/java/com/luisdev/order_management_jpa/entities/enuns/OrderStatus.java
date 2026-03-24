package com.luisdev.order_management_jpa.entities.enuns;

public enum OrderStatus {

    PENDING("Pending", false),
    CONFIRMED("Confirmed", false),
    PROCESSING("Processing", false),
    SHIPPED("Shipped", false),
    DELIVERED("Delivered", true),
    CANCELLED("Cancelled", true),
    FAILED("Failed", true),
    RETURNED("Returned", true);

    private final String description;
    private final boolean isFinal;

    OrderStatus(String description, boolean isFinal) {
        this.description = description;
        this.isFinal = isFinal;
    }

    public String getDescription() {
        return description;
    }

    public boolean isFinal() {
        return isFinal;
    }

    // Regra de transição de status
    public boolean canChangeTo(OrderStatus newStatus) {
        return switch (this) {
            case PENDING -> newStatus == CONFIRMED || newStatus == CANCELLED;
            case CONFIRMED -> newStatus == PROCESSING || newStatus == CANCELLED;
            case PROCESSING -> newStatus == SHIPPED;
            case SHIPPED -> newStatus == DELIVERED;
            default -> false;
        };
    }
}