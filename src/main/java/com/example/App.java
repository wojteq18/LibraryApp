package com.example;


public class App 
{
    public static void main( String[] args )
    {
        Book book = new Book("Wiedzmin", "Andrzej Sapkowski");
        Reader reader = new Reader("Jan Kowalski");

        book.add_copy(7);
        System.out.println("Book: " + book.get_title() + " by " + book.get_author());
        System.out.println("Copies of " + book.get_title() + ": " + book.get_copies().size());
        reader.reader_borrow_book(book);
        System.out.println("Borrowed books by " + reader.get_reader_name() + ": " + reader.get_borrowed_books());
    }
}
