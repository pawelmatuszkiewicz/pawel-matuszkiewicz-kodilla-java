package com.kodilla.good.patterns.challenges;

public class ProductOrderRepository implements OrderRepository {

    @Override
    public void createOrder(final OrderRequest orderRequest) {
        System.out.println("Order " + '[' + orderRequest.getProduct().getName()
                    + ", " + orderRequest.getQuantity() + " pcs.] "
                    + "added to product order repository with id #12345.");
    }
}
