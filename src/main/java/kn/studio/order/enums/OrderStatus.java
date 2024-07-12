package kn.studio.order.enums;

public enum OrderStatus {
    TO_PREPARE,
    READY,
    TO_DELIVERY, // only for online order delivered by delivery man
    DELIVERED,
    PICKED_UP
}
