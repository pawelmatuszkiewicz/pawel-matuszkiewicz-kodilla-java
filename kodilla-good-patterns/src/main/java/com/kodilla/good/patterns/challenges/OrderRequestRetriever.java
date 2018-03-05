package com.kodilla.good.patterns.challenges;

public class OrderRequestRetriever {

    public OrderRequest retrieve() {

        User user = new User("Alan", "Smith");
        Product product = new Product("LED bulb E27 11W", 9);
        int quantity = 3;

        return new OrderRequest(user,product, quantity);
    }
}
