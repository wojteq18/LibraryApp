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
    int index = books.indexOf(book);
    if (index != -1) { // Sprawdza, czy książka już istnieje w kolekcji
        books.get(index).add_copy(ilosc); // Dodaje kopie do istniejącej książki
    } else {
        book.add_copy(ilosc); // Dodaje kopie do nowego obiektu
        books.add(book); // Dodaje nową książkę do listy
    }
}

    public void add_user(Reader reader)
    {
        users.add(reader);
    }

    public void remove_user(Reader reader)
    {
        if(users.contains(reader))
        {
            users.remove(reader);
        }
        else
        {
            System.out.println("This user is not in the library");
        }    
    }

    @Override
    public String toString()
    {
        return "Library: " + books + " " + users;
    }
}