package com.kodilla.patterns.prototype.library;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class LibraryTestSuite {
    @Test
    public void testGetBooks() {
        //Given
        Library library = new Library("Library");
        library.getBooks().add(
                new Book("Ogniem i mieczem", "Henryk Sienkiewicz", LocalDate.of(1884, 1, 2)));
        library.getBooks().add(
                new Book("Kod Leonarda da Vinci", "Dan Brown", LocalDate.of(2003, 3, 4)));
        library.getBooks().add(
                new Book("Alchemik", "Paulo Coelho", LocalDate.of(1988, 5, 6)));
        library.getBooks().add(
                new Book("Harry Potter i Zakon Feniksa", "J.K. Rowling", LocalDate.of(2003, 7, 8)));
        library.getBooks().add(
                new Book("Mewa", "Mewa", LocalDate.of(1970, 9, 10)));

        //When
        Library shallowClonedLibrary = null;
        try {
            shallowClonedLibrary = library.shallowCopy();
            shallowClonedLibrary.setName("Shallow Cloned Library");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        Library deepClonedLibrary = null;
        try {
            deepClonedLibrary = library.deepCopy();
            deepClonedLibrary.setName("Deep Cloned Library");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        System.out.println(library);
        System.out.println(shallowClonedLibrary);
        System.out.println(deepClonedLibrary);

        library.getBooks().remove(new Book("Mewa", "Mewa", LocalDate.of(1970, 9, 10)));

        //Then
        System.out.println(library);
        System.out.println(shallowClonedLibrary);
        System.out.println(deepClonedLibrary);

        Assert.assertEquals(4, library.getBooks().size());
        Assert.assertEquals(4, shallowClonedLibrary.getBooks().size());
        Assert.assertEquals(5, deepClonedLibrary.getBooks().size());
        Assert.assertEquals(library.getBooks(), shallowClonedLibrary.getBooks());
        Assert.assertNotEquals(library.getBooks(), deepClonedLibrary.getBooks());
    }
}
