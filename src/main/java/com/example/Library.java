package com.example;

import java.util.ArrayList;
import java.util.List;

public class Library
{
    private List<Book> books;
    private List<Reader> users;

    public Library()
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
        if (index != -1) {
            books.get(index).add_copy(ilosc);
        }
        else 
        {
            book.add_copy(ilosc);
            books.add(book);
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

    public Book find_book_by_author_and_title(String author, String title)
    {
        for (Book book : books)
        {
            if (book.get_author().equals(author) && book.get_title().equals(title))
            {
                return book;
            }
        }
        return null;
    }

    public Reader find_user_by_name(String name)
    {
        for (Reader user : users)
        {
            if (user.get_reader_name().equals(name))
            {
                return user;
            }
        }
        return null;
    }

    @Override
    public String toString()
    {
        return "Library: " + books + " " + users;
    }
}
