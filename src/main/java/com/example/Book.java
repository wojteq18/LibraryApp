package com.example;

import java.util.ArrayList;
import java.util.List;

public class Book
{
    private String title;
    private String author;
    private List<Copy> copies;

    public Book(String title, String author)
    {
        this.title = title;
        this.author = author;
        this.copies = new ArrayList<>();
    }

    public String get_title()
    {
        return title;
    }

    public String get_author()
    {
        return author;
    }

    public List<Copy> get_copies()
    {
        return copies;
    }

    public int get_number_of_copies()
    {
        return copies.size();
    }

    public void add_copy(int number_of_copies)
    {
        for (int i = 0; i < number_of_copies; i++)
        {
            copies.add(new Copy(this));
        }
    }

    public boolean borrow_copy()
    {
        Copy available_copy = copies.stream().filter(Copy::is_available).findFirst().orElse(null);
        if(available_copy != null)
        {
            available_copy.borrow_book();
            return true;
        }
        return false;
    }

    public void return_copy()
    {
        Copy borrow_from_copy = copies.stream().filter(copy -> !copy.is_available()).findFirst().orElse(null);
        if(borrow_from_copy != null)
        {
            borrow_from_copy.return_book();
        }
        else
        {
            System.out.println("No copies to return");
        }
    }

    @Override
    public String toString()
    {
        return "Book: " + title + " by " + author;
    }
}
