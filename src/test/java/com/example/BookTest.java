package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;  // Import dla assertEquals
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BookTest
{
    private Book book;

    @BeforeEach
    void set_up()
    {
        book = new Book("Wiedzmin", "Andrzej Sapkowski");
    }

    @Test
    void test_add_copy()
    {
        book.add_copy(2);
        assertEquals(2, book.get_number_of_copies());
    }

    @Test
    void test_borrow_copy()
    {
        book.add_copy(1);
        boolean result = book.borrow_copy();
        assertTrue(result);
        assertFalse(book.get_copies().get(0).is_available());
    }

    @Test
    void test_return_copy()
    {
        book.add_copy(1);
        book.borrow_copy();
        book.return_copy();
        assertTrue(book.get_copies().get(0).is_available());
    }
}