package com.kodilla.good.patterns.order.system;

public class ExtraFoodShop implements ProductSupply {
    private String name;
    private String bankAccountNr;

    ExtraFoodShop(String name, String bankAccountNr) {
        this.name = name;
        this.bankAccountNr = bankAccountNr;
    }

    @Override
    public boolean process(final Product product, final double quantity) {

        System.out.println("Supplier: " + name + ", bank account: " + bankAccountNr);
        System.out.println("Order created: [" + product.getName()
                + ", unit price: " + product.getPrice() + " /" + product.getUnit()
                + ", quantity: " + quantity + ", price: "
                + product.getPrice() * quantity + ']');
        return true;
    }
}
