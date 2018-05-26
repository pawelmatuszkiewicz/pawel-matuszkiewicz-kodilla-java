package com.kodilla.patterns2.adapter.bookclasifier.librarya;

import java.util.Objects;

public class Book {
    private final String author;
    private final String titel;
    private final int publicationYear;
    private final String signature;

    public Book(String author, String title, int publicationYear, String signature) {
        this.author = author;
        this.titel = title;
        this.publicationYear = publicationYear;
        this.signature = signature;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return titel;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public String getSignature() {
        return signature;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(signature, book.signature);
    }

    @Override
    public int hashCode() {

        return Objects.hash(signature);
    }
}
