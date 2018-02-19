package com.kodilla.stream.world;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class WorldTestSuite {
    @Test
    public void testGetPeopleQuantity() {
        // Given
        Continent continent1 = new Continent("North America");
        continent1.addCountry(new Country("USA", 326625791));
        continent1.addCountry(new Country("Canada", 35623680));
        // adding the same country - should be skipped
        continent1.addCountry(new Country("Canada", 10000000));
        Continent continent2 = new Continent("Europe");
        continent2.addCountry(new Country("Poland", 38500000));
        continent2.addCountry(new Country("Germany", 80594017));
        Continent continent3 = new Continent("Asia");
        continent3.addCountry(new Country("China", 1400000000));
        continent3.addCountry(new Country("Pakistan", 205000000));
        Continent continent4 = new Continent("South America");
        continent4.addCountry(new Country("Brazil", 207500000));

        World world = new World();
        world.addContinent(continent1);
        world.addContinent(continent2);
        world.addContinent(continent3);
        world.addContinent(continent4);
        // When
        BigDecimal totalPeopleQuantity = world.getPeopleQuantity();
        // Then
        Assert.assertEquals(new BigDecimal("2293843488"), totalPeopleQuantity);
    }
}