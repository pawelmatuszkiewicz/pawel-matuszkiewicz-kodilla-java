package com.kodilla.good.patterns.order.system;

public class HealthyShop implements ProductSupply {
    private String name;
    private String bankAccountNr;

    HealthyShop(String name, String bankAccountNr) {
        this.name = name;
        this.bankAccountNr = bankAccountNr;
    }

    @Override
    public boolean process(final Product product, final double quantity) {

        System.out.println("Supplier: " + name + ", bank account: " + bankAccountNr);

        if (quantity < 10) {
            System.out.println("Order created: [" + product.getName()
                    + ", unit price: " + product.getPrice() + " /" + product.getUnit()
                    + ", quantity: " + quantity + ", price: "
                    + product.getPrice() * quantity + ']');
            return true;
        } else {
            System.out.println("Can't create order: product out of stock!");
            return false;
        }
    }
}
