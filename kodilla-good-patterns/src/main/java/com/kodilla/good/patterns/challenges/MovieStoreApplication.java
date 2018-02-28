package com.kodilla.good.patterns.challenges;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MovieStoreApplication {

    public static void main(String[] args) {

        MovieStore movieStore = new MovieStore();
        Map<String, List<String>> booksTitlesWithTranslations = movieStore.getMovies();

        String booksTitles =  booksTitlesWithTranslations.entrySet().stream()
                .map(Map.Entry::getValue)
                .flatMap(List::stream)
                .collect(Collectors.joining(" ! "));

        System.out.println(booksTitles);
    }
}
