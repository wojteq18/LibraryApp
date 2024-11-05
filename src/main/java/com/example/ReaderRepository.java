package com.example;

import java.util.List;

public interface ReaderRepository
{
    void add_reader(Reader reader);
    Reader find_by_name(String name);
    List<Reader> find_all_readers();
    void remove_reader(Reader reader);
}