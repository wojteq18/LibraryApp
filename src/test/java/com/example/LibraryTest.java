package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;  // Import dla assertEquals

class LibraryTest
{
    private Library library;
    private Book book;
    private Reader reader;

    @BeforeEach
    void set_up()
    {
        library = new Library();
        book = new Book("Wiedzmin", "Andrzej Sapkowski");
        reader = new Reader("Jan Kowalski");
        book.add_copy(1);
    }

    @Test
    void books_in_library_test()
    {
        library.add_book(book, 3);
        assertEquals(1, library.get_books().size());
        assertEquals(4, book.get_number_of_copies()); //4, bo dodalismy 1 egzemplarz w setUp() i 3 w add_book()
    }

    @Test
    void users_in_library_test()
    {
        library.add_user(reader);
        assertEquals(1, library.get_user().size());
        assertEquals("Jan Kowalski", library.get_user().get(0).get_reader_name());
    }
}