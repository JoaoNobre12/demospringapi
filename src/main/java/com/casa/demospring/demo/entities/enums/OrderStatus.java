package com.casa.demospring.demo.entities.enums;

public enum OrderStatus {
    WAITING_PAYMENT(0),
    PAID(1),
    SHIPPED(2),
    DELIVERED(3),
    CANCELED(4);

    private final int value;
    OrderStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
