package com.example;

import java.util.List;

public interface BookRepository
{
    void add_book(Book book, int ilosc);
    Book find_by_title_and_author(String title, String author);
    List<Book> find_all_books();
}