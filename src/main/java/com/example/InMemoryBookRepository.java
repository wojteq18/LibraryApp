package com.example;

import java.util.ArrayList;
import java.util.List;

public class InMemoryBookRepository implements BookRepository
{
    private final List<Book> books = new ArrayList<>();

    @Override
    public void add_book(Book book, int copies)
    {
        int index = books.indexOf(book);
        if (index != - 1)
        {
            books.get(index).add_copy(copies); //index dziala na liscie books, jesli znajdzie jego pozycje, zwroci jego pozycje na liscie, jesli nie, zwroci -1
        }
        else
        {
            book.add_copy(copies);
            books.add(book);
        }
    }

    @Override
    public Book find_by_title_and_author(String title, String author)
    {
        return books.stream()
                .filter(book -> book.get_title().equals(title) && book.get_author().equals(author))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Book> find_all_books()
    {
        return new ArrayList<>(books);
    }
}