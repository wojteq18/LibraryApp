package com.example;

// Klasa Copy reprezentuje pojedynczą kopię książki.
// Zasada High Cohesion jest zachowana, ponieważ klasa Copy ma dobrze zdefiniowane odpowiedzialności związane z pojedynczą kopią książki.

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
