package com.example;

public class Copy
{
    private Book book;
    private boolean available;

    public Copy(Book book)
    {
        this.book = book;
        available = true;
    }

    public Book get_book()
    {
        return book;
    }

    public boolean is_available()
    {
        return available;
    }

    public void borrow_book()
    {
        available = false;
    }

    public void return_book()
    {
        available = true;
    }
}
