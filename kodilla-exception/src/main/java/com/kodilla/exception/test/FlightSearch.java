package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightSearch {
    public void findFilght(Flight flight) throws RouteNotFoundException {
        Map<String, Boolean> flightsMap = new HashMap<>();
        flightsMap.put("New York", true);
        flightsMap.put("Paris", true);
        flightsMap.put("London", true);
        flightsMap.put("Munich", false);

        Boolean result = flightsMap.get(flight.arrivalAirport);
        if ( result != null ) {
            if (result.equals(true)) {
                System.out.println("Found flight from " + flight.getDepartureAirport()
                        + " to " + flight.getArrivalAirport());
            }
        }
        else {
            throw new RouteNotFoundException("Can't find specified destination airport.");
        }
    }
}

