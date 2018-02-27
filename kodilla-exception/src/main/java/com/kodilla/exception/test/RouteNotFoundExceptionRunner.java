package com.kodilla.exception.test;

public class RouteNotFoundExceptionRunner {
    public static void main(String[] args) {
        FlightSearch flightSearch = new FlightSearch();

        try {
            flightSearch.findFilght(new Flight("Warsaw", "Geneva"));
        } catch (RouteNotFoundException e) {
            System.out.println("Oops! Route not found: " + e);
        }
    }
}
