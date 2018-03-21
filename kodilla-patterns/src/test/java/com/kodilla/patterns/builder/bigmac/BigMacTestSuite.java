package com.kodilla.patterns.builder.bigmac;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class BigMacTestSuite {
    @Test
    public void testBigMacNew() {
        //Given
        BigMac bigMac = new BigMac.BigMacBuilder()
                            .roll("with sesame")
                            .burgers(2)
                            .sauce("barbecue")
                            .ingredient("onion")
                            .ingredient("mushrooms")
                            .build();
        //When
        System.out.println(bigMac);
        String roll = bigMac.getRoll();
        int burgers = bigMac.getBurgers();
        String sauce = bigMac.getSauce();
        List<String> ingredients = bigMac.getIngredients();
        //Then
        Assert.assertEquals("with sesame", roll);
        Assert.assertEquals(2, burgers);
        Assert.assertEquals("barbecue", sauce);
        Assert.assertEquals(2, ingredients.size());
    }
}
