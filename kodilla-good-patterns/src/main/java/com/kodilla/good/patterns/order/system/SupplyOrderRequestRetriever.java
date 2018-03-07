package com.kodilla.good.patterns.order.system;

import java.util.ArrayList;
import java.util.List;

public class SupplyOrderRequestRetriever {
    private List<SupplyOrderRequest> supplierOrderRequests = new ArrayList<>();

    List<SupplyOrderRequest> retrieve() {
        Product product1 = new Product("Extra onion soup", "pc.", 3);
        ProductSupply supplier1 = new ExtraFoodShop("Extra Food Shop", "123456789");
        SupplyOrderRequest orderRequest1 = new SupplyOrderRequest(supplier1, product1, 10);
        supplierOrderRequests.add(orderRequest1);

        Product product2 = new Product("Fruit bar", "pc.", 1.5);
        ProductSupply supplier2 = new HealthyShop("Healthy Shop", "987654321");
        SupplyOrderRequest orderRequest2 = new SupplyOrderRequest(supplier2, product2, 100);
        supplierOrderRequests.add(orderRequest2);

        Product product3 = new Product("Gluten-free flakes", "pc.", 5);
        ProductSupply supplier3 = new GlutenFreeShop("Gluten-free Shop", "1122334455");
        SupplyOrderRequest orderRequest3 = new SupplyOrderRequest(supplier3, product3, 200);
        supplierOrderRequests.add(orderRequest3);

        return supplierOrderRequests;
    }
}
