package com.kodilla.good.patterns.Flights;

public interface SearchService {
    void searchFrom(String from);
    void searchTo(String to);
    void searchFromToVia(String from, String to, String via);
}
