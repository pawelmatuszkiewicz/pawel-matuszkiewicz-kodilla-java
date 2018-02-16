package com.kodilla.testing.library;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class BookDirectoryTestSuite {
    private List<Book> generateListOfNBooks(int booksQuantity) {
        List<Book> resultList = new ArrayList<Book>();
        for(int n = 1; n <= booksQuantity; n++){
            Book theBook = new Book("Title " + n, "Author " + n, 1970 + n);
            resultList.add(theBook);
        }
        return resultList;
    }

    @Test
    public void testListBooksWithConditionsReturnList() {
        // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOfBooks = new ArrayList<Book>();
        Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);
        Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);
        Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016);
        Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);
        resultListOfBooks.add(book1);
        resultListOfBooks.add(book2);
        resultListOfBooks.add(book3);
        resultListOfBooks.add(book4);
        when(libraryDatabaseMock.listBooksWithCondition("Secret"))
                .thenReturn(resultListOfBooks);

        // When
        List<Book> theListOfBooks = bookLibrary.listBooksWithCondition("Secret");

        // Then
        assertEquals(4, theListOfBooks.size());
    }

    @Test
    public void testListBooksWithConditionMoreThan20() {
        // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOf0Books = new ArrayList<Book>();
        List<Book> resultListOf15Books = generateListOfNBooks(15);
        List<Book> resultListOf40Books = generateListOfNBooks(40);
        when(libraryDatabaseMock.listBooksWithCondition(anyString()))
                .thenReturn(resultListOf15Books);
        when(libraryDatabaseMock.listBooksWithCondition("ZeroBooks"))
                .thenReturn(resultListOf0Books);
        when(libraryDatabaseMock.listBooksWithCondition("FourtyBooks"))
                .thenReturn(resultListOf40Books);

        // When
        List<Book> theListOfBooks0 = bookLibrary.listBooksWithCondition("ZeroBooks");
        List<Book> theListOfBooks15 = bookLibrary.listBooksWithCondition("Any title");
        List<Book> theListOfBooks40 = bookLibrary.listBooksWithCondition("FourtyBooks");
        // Then

        assertEquals(0, theListOfBooks0.size());
        assertEquals(15, theListOfBooks15.size());
        assertEquals(0, theListOfBooks40.size());
    }

    @Test
    public void testListBooksWithConditionFragmentShorterThan3() {
        // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOf10Books = generateListOfNBooks(10);
        when(libraryDatabaseMock.listBooksWithCondition(anyString()))
                .thenReturn(resultListOf10Books);

        // When
        List<Book> theListOfBooks10 = bookLibrary.listBooksWithCondition("An");

        // Then
        assertEquals(0, theListOfBooks10.size());
        verify(libraryDatabaseMock, times(0)).listBooksWithCondition(anyString());
    }

    @Test
    public void testListBooksInHandsOfNoBooks() {
        // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        LibraryUser libraryUser = new LibraryUser("First name", "Last name", "123456789");
        List<Book> resultListOfBooks = new ArrayList<Book>();
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser)).thenReturn(resultListOfBooks);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        // When
        List<Book>  borrowedBooks = bookLibrary.listBooksInHandsOf(libraryUser);
        // Then
        assertEquals(0, borrowedBooks.size());
    }

    @Test
    public void testListBooksInHandsOf() {
        // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        LibraryUser libraryUser1 = new LibraryUser("First name", "Last name", "1");
        LibraryUser libraryUser5 = new LibraryUser("First name", "Last name", "5");
        LibraryUser libraryUser12 = new LibraryUser("First name", "Last name", "12");
        List<Book> resultListOfBooks1 = generateListOfNBooks(1);
        List<Book> resultListOfBooks5 = generateListOfNBooks(5);
        List<Book> resultListOfBooks12 = generateListOfNBooks(12);
        when(libraryDatabaseMock.listBooksInHandsOf(anyObject())).thenReturn(resultListOfBooks12);
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser1)).thenReturn(resultListOfBooks1);
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser5)).thenReturn(resultListOfBooks5);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        // When
        List<Book>  borrowedBooks1 = bookLibrary.listBooksInHandsOf(libraryUser1);
        List<Book>  borrowedBooks5 = bookLibrary.listBooksInHandsOf(libraryUser5);
        List<Book>  borrowedBooks12 = bookLibrary.listBooksInHandsOf(libraryUser12);
        // Then
        assertEquals(1,borrowedBooks1.size());
        assertEquals(5,borrowedBooks5.size());
        assertEquals(12,borrowedBooks12.size());
        verify(libraryDatabaseMock, times(3))
                .listBooksInHandsOf(anyObject());
    }
}
