package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public final class World {
    private final Set<Continent> continents = new HashSet<>();

    public void addContinent(Continent continent) {
        continents.add(continent);
    }

    public BigDecimal getPeopleQuantity() {
        return continents.stream()
                 .flatMap(continent -> continent.getCountries().stream())
                 .map(country -> country.getPeopleQuantity())
                 .reduce(BigDecimal.ZERO, (sum, curr) -> sum = sum.add(curr));
    }

    public Set<Continent> getContinents() {
        return continents;
    }
}
