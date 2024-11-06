package com.example;

import java.util.List;

// Interfejs BookRepository definiuje abstrakcyjne metody do zarządzania książkami w bibliotece.
// Zasada Dependency Inversion jest zachowana, ponieważ wysokopoziomowe moduły (Library) zależą od abstrakcji (BookRepository), a nie od konkretnych implementacji.

public interface BookRepository
{
    void add_book(Book book, int ilosc);
    Book find_by_title_and_author(String title, String author);
    List<Book> find_all_books();
}