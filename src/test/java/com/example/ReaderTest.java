package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;  // Import dla assertEquals
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReaderTest
{
    private Reader reader;
    private Book book;

    @BeforeEach
    void set_up()
    {
        reader = new Reader("Jan Kowalski");
        book = new Book("Wiedzmin", "Andrzej Sapkowski");
        book.add_copy(1);
    }

    @Test
    void test_reader_borrow_book()
    {
        reader.reader_borrow_book(book);
        assertEquals(1, reader.get_number_of_borrowed_books());
        assertFalse(book.get_copies().get(0).is_available()); //sprawdza czy pierwszy egzemplarz ksiazki jest niedostepny
    }

    @Test
    void test_reader_return_book()
    {
        reader.reader_borrow_book(book);
        reader.reader_return_book(book);
        assertEquals(0, reader.get_number_of_borrowed_books());
        assertTrue(book.get_copies().get(0).is_available());
    }
}