package com.example;

import java.util.ArrayList;
import java.util.List;

// Klasa InMemoryBookRepository jest konkretną implementacją interfejsu BookRepository, przechowującą książki w pamięci.
// Zasada Pure Fabrication jest zachowana, ponieważ klasa ta jest sztuczną klasą, która pomaga spełniać odpowiedzialności aplikacji.

public class InMemoryBookRepository implements BookRepository
{
    private final List<Book> books = new ArrayList<>();

    @Override
    public void add_book(Book book, int copies)
    {
        int index = books.indexOf(book);
        if (index != - 1)
        {
            books.get(index).add_copy(copies); //index dziala na liscie books, jesli znajdzie jego pozycje, zwroci jego pozycje na liscie, jesli nie, zwroci -1
        }
        else
        {
            book.add_copy(copies);
            books.add(book);
        }
    }

    @Override
    public Book find_by_title_and_author(String title, String author)
    {
        return books.stream() //stram tworzy strumień, który pozwala na wykonanie operacji przetwarzania danych
                .filter(book -> book.get_title().equals(title) && book.get_author().equals(author)) //sprawdzamy czy tytul i autor sa takie same jak podane
                .findFirst() //zwraca pierwszy element ze strumienia
                .orElse(null); //zwraca null jesli optional jest pusty
    }

    @Override
    public List<Book> find_all_books()
    {
        return new ArrayList<>(books);
    }
}