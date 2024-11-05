package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LibraryTest
{
    private Library library;
    private Book book;
    private Reader reader;

    @BeforeEach
    void set_up()
    {
        // Inicjalizacja zmiennej instancyjnej `library` (zamiast tworzyć lokalną zmienną)
        library = new Library(new InMemoryBookRepository(), new InMemoryReaderRepository());
        book = new Book("Wiedzmin", "Andrzej Sapkowski");
        reader = new Reader("Jan Kowalski");
        book.add_copy(1); // Dodajemy 1 egzemplarz w setupie
    }

    @Test
    void books_in_library_test()
    {
        library.add_book(book, 3); // Dodajemy dodatkowe 3 egzemplarze do biblioteki
        assertEquals(1, library.get_books().size()); // Sprawdzamy liczbę książek w bibliotece
        assertEquals(4, book.get_number_of_copies()); // Powinno być 4 kopie w sumie
    }

    @Test
    void users_in_library_test()
    {
        library.add_user(reader); // Dodajemy czytelnika do biblioteki
        assertEquals(1, library.get_users().size()); // Sprawdzamy liczbę użytkowników
        assertEquals("Jan Kowalski", library.get_users().get(0).get_reader_name()); // Sprawdzamy imię użytkownika
    }
}
