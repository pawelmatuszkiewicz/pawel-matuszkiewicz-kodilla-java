package com.kodilla.good.patterns.order.system;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        SupplyOrderRequestRetriever supplierOrderRequestRetriever = new SupplyOrderRequestRetriever();
        List<SupplyOrderRequest> orderRequests = supplierOrderRequestRetriever.retrieve();

        orderRequests.forEach(SupplyOrderProcessor::process);
    }
}
