package com.example;


public class App 
{
    public static void main( String[] args )
    {
        Book book = new Book("Wiedzmin", "Andrzej Sapkowski");
        Reader reader = new Reader("Jan Kowalski");
        book.add_copy(22);
        System.out.println("Book: " + book.get_title() + " by " + book.get_author());
        System.out.println("Copies of " + book.get_title() + ": " + book.get_copies().size());
        reader.reader_borrow_book(book);
        reader.reader_borrow_book(book);
        System.out.println("Borrowed books by " + reader.get_reader_name() + ": " + reader.get_borrowed_books());
        System.out.println("Number of borrowed books by " + reader.get_reader_name() + ": " + reader.get_number_of_borrowed_books());
        Library library = new Library(null, null);
        library.add_book(book, 2);
        library.add_user(reader);
        System.out.println("Books in library: " + library.get_books());
        System.out.println("Users in library: " + library.get_user());
    }
}
