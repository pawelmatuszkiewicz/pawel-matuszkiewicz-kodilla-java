package com.kodilla.patterns2.decorator.pizza;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class PizzaOrderTestSuite {
    @Test
    public void testPizzaWithExtraCheeseTomatoes() {
        // Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new ExtraCheeseDecorator(pizzaOrder);
        pizzaOrder = new TomatoToppingDecorator(pizzaOrder);
        // When
        BigDecimal pizzaCost = pizzaOrder.getCost();
        String description = pizzaOrder.getDescription();
        // Then
        assertEquals(pizzaCost, new BigDecimal(20));
        assertEquals(description, "Tomato sauce, Mozarella, Extra cheese, Sliced tomatoes");
    }

    @Test
    public void testLargePizzaWithExtraCheeseTomatoesMushroomOlivesHam() {
        // Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new LargePizzaDecorator(pizzaOrder);
        pizzaOrder = new ExtraCheeseDecorator(pizzaOrder);
        pizzaOrder = new TomatoToppingDecorator(pizzaOrder);
        pizzaOrder = new MushroomToppingDecorator(pizzaOrder);
        pizzaOrder = new OlivesToppingDecorator(pizzaOrder);
        pizzaOrder = new HamToppingDecorator(pizzaOrder);
        // When
        BigDecimal pizzaCost = pizzaOrder.getCost();
        String description = pizzaOrder.getDescription();
        System.out.println(description);
        System.out.println("Price: " + pizzaCost);
        // Then
        assertEquals(pizzaCost, new BigDecimal(31));
        assertEquals(description, "[Large] Tomato sauce, Mozarella, Extra cheese, Sliced tomatoes," +
                " Mushroom, Olives, Ham");
    }
}
