package com.kodilla.good.patterns.order.system;

public class SupplyOrderProcessor {

    public static boolean process(final SupplyOrderRequest orderRequest) {

        return orderRequest.getSupplier().process(orderRequest.getProduct(),
                                                orderRequest.getQuantity());
    }
}
