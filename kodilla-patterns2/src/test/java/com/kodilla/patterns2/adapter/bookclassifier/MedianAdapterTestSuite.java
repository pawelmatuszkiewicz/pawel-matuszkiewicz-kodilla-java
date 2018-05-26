package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclasifier.MedianAdapter;
import com.kodilla.patterns2.adapter.bookclasifier.librarya.Book;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class MedianAdapterTestSuite {
    @Test
    public void publicationYearMedianTest() {
        // Given
        Set<Book> books = new HashSet<>();
        books.add(new Book("Author1", "Title1", 1977, "LibraryA/#1"));
        books.add(new Book("Author2", "Title2", 1999, "LibraryA/#2"));
        books.add(new Book("Author3", "Title3", 2011, "LibraryA/#3"));
        books.add(new Book("Author4", "Title4", 1962, "LibraryA/#4"));
        books.add(new Book("Author5", "Title5", 2002, "LibraryA/#5"));
        books.add(new Book("Author6", "Title6", 2000, "LibraryA/#6"));
        MedianAdapter adapter = new MedianAdapter();
        // When
        int publicationYearMedian = adapter.publicationYearMedian(books);
        System.out.println("Publication year median: " + publicationYearMedian);
        // Then
        assertEquals(2000, publicationYearMedian);
    }
}
