package com.example;

import java.util.List;

// Interfejs ReaderRepository definiuje abstrakcyjne metody do zarządzania czytelnikami w bibliotece.
// Zasada Dependency Inversion jest zachowana, ponieważ wysokopoziomowe moduły (Library) zależą od abstrakcji (ReaderRepository), a nie od konkretnych implementacji.

public interface ReaderRepository
{
    void add_reader(Reader reader);
    Reader find_by_name(String name);
    List<Reader> find_all_readers();
    void remove_reader(Reader reader);
}