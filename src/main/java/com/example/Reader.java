package com.example;
import java.util.ArrayList;
import java.util.List;

public class Reader
{
    private String reader_name;
    private List<Book> borrowed_books;

    public Reader(String reader_name)
    {
        this.reader_name = reader_name;
        this.borrowed_books = new ArrayList<>();
    } 

    public String get_reader_name()
    {
        return reader_name;
    }

    public List<Book> get_borrowed_books()
    {
        return borrowed_books;
    }

    public int get_number_of_borrowed_books()
    {
        return borrowed_books.size();
    }

    public void reader_borrow_book(Book book)
    {
        if(book.borrow_copy() == true)
        {
            borrowed_books.add(book);
        }
        else
        {
            System.out.println("No available copies of " + book.get_title() + " by: " + book.get_author());
        }
    }

    public void reader_return_book(Book book)
    {
        if(borrowed_books.contains(book))
        {
            borrowed_books.remove(book);
            book.return_copy();
        }
        else
        {
            System.out.println("This book is not borrowed by " + reader_name);
        }    
    }

    @Override
    public String toString()
    {
        return "Reader: " + reader_name;
    }
}