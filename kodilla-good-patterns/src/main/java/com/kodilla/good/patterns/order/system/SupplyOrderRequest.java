package com.kodilla.good.patterns.order.system;

public class SupplyOrderRequest {
    private ProductSupply supplier;
    private Product product;
    private double quantity;

    SupplyOrderRequest(ProductSupply supplier, Product product, double quantity) {
        this.supplier = supplier;
        this.product = product;
        this.quantity = quantity;
    }

    public ProductSupply getSupplier() {
        return supplier;
    }

    public Product getProduct() {
        return product;
    }

    public double getQuantity() {
        return quantity;
    }
}
