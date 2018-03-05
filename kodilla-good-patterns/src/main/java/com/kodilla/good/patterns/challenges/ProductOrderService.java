package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;

public class ProductOrderService implements OrderService {

    @Override
    public boolean order(final User user, final Product product, final int quantity) {

        System.out.println("Created order: [ "
                + LocalDateTime.now() + " user: " + user.getFirstName()
                + " " + user.getLastName() + " product: "
                + product.getName() + " quantity: " + quantity
                + " price: " + quantity * product.getPrice() + " ]");
        return true;
    }
}
