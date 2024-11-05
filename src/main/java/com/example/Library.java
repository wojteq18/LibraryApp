package com.example;

import java.util.List;

public class Library
{
    private final BookRepository book_repository;
    private final ReaderRepository reader_repository;

    public Library(BookRepository book_repository, ReaderRepository reader_repository)
    {
        this.book_repository = book_repository;
        this.reader_repository = reader_repository;
    }

    public void add_book(Book book, int ilosc) 
    {
        book_repository.add_book(book, ilosc);
    }

    public void add_user(Reader reader)
    {
        reader_repository.add_reader(reader);
    }

    public void remove_user(Reader reader)
    {
       if (reader_repository.find_by_name(reader.get_reader_name()) != null)
       {
           reader_repository.remove_reader(reader);
       }
       else
       {
           System.out.println("User not found in the library");
       }
    }

    public Book find_book_by_author_and_title(String author, String title)
    {
        return book_repository.find_by_title_and_author(title, author);
    }

    public Reader find_user_by_name(String name)
    {
        return reader_repository.find_by_name(name);
    }

    public void display_books()
    {
        System.out.println(book_repository.find_all_books());
    }

    public void display_users()
    {
        System.out.println(reader_repository.find_all_readers());
    }

    public List<Book> get_books()
    {
        return book_repository.find_all_books();
    }

    public List<Reader> get_users()
    {
        return reader_repository.find_all_readers();
    }
}
