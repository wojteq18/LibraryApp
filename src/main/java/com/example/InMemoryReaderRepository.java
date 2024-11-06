package com.example;

import java.util.ArrayList;
import java.util.List;

// Klasa InMemoryReaderRepository jest konkretną implementacją interfejsu ReaderRepository, przechowującą czytelników w pamięci.
// Zasada Pure Fabrication jest zachowana, ponieważ klasa ta jest sztuczną klasą, która pomaga spełniać odpowiedzialności aplikacji.

public class InMemoryReaderRepository implements ReaderRepository
{
    private final List<Reader> readers = new ArrayList<>();

    @Override
    public void add_reader(Reader reader)
    {
        readers.add(reader);
    }

    @Override
    public Reader find_by_name(String name)
    {
        return readers.stream()
                .filter(reader -> reader.get_reader_name().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Reader> find_all_readers()
    {
        return new ArrayList<>(readers);
    }

    @Override
    public void remove_reader(Reader reader)
    {
        readers.remove(reader);
    }
}