package com.kodilla.good.patterns.order.system;

public class GlutenFreeShop implements ProductSupply {
    private String name;
    private String bankAccountNr;

    GlutenFreeShop(String name, String bankAccountNr) {
        this.name = name;
        this.bankAccountNr = bankAccountNr;
    }

    @Override
    public boolean process(final Product product, final double quantity) {

        System.out.println("Supplier: " + name + ", bank account: " + bankAccountNr);
        if (quantity >= 100) {
            System.out.println("Order created: [" + product.getName()
                    + ", unit price: " + product.getPrice() + " /" + product.getUnit()
                    + ", quantity: " + quantity + ", price with discount: "
                    + product.getPrice() * quantity * 0.9 + ']');
        } else {
            System.out.println("Order created: [" + product.getName()
                    + ", unit price: " + product.getPrice() + " /" + product.getUnit()
                    + ", quantity: " + quantity + ", price with discount: "
                    + product.getPrice() * quantity + ']');
        }
        return true;
    }
}
