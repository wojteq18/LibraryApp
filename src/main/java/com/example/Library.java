package com.example;
import java.util.ArrayList;
import java.util.List;

public class Library
{
    private List<Book> books;
    private List<Reader> users;

    public Library(List<Book> books, List<Reader> readers)
    {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public List<Book> get_books()
    {
        return books;
    }

    public List<Reader> get_user()
    {
        return users;
    }

    public void add_book(Book book, int ilosc)
    {
        if(books.contains(book))
        {
            book.add_copy(ilosc);
        }
        else
        {
            books.add(book);
            book.add_copy(ilosc);
        }
    }

    public void add_user(Reader reader)
    {
        users.add(reader);
    }

    private void remove_user(Reader reader)
    {
        users.remove(reader);
    }

    @Override
    public String toString()
    {
        return "Library: " + books + " " + users;
    }
}