package com.example;

import java.util.Scanner;

public class App 
{
    public static void main(String[] args)
    {
        Library library = new Library(new InMemoryBookRepository(), new InMemoryReaderRepository());
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running)
        {
            System.out.println("1. Add book to library");
            System.out.println("2. Add user to library");
            System.out.println("3. Remove user from library");
            System.out.println("4. Add book to user");
            System.out.println("5. Remove book from user");
            System.out.println("6. Books in library");
            System.out.println("7. Users in library");
            System.out.println("8. Users books");
            System.out.println("9. Number of books");
            System.out.println("10. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Wyczyść bufor po nextInt(), aby uniknąć problemów przy następnym nextLine()
            switch (choice)
            {
                case 1: 
                    System.out.println("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.println("Enter book author: ");
                    String author = scanner.nextLine();
                    if(author.isEmpty() || title.isEmpty() || !author.matches("[a-zA-Z]+") || !title.matches("[a-zA-Z]+")) // Sprawdź, czy tytuł i autor książki zawierają tylko litery
                    {
                        System.out.println("Invalid book title or author");
                        break;
                    }
                    System.out.println("Enter book copies: ");
                    int copies = scanner.nextInt();
                    if (copies < 0)
                    {
                        System.out.println("Invalid number of copies");
                        break;
                    }
                    scanner.nextLine();
                    Book book = new Book(title, author);
                    library.add_book(book, copies);
                    break;

                case 2: 
                    System.out.println("Enter user name: ");
                    String name = scanner.nextLine();
                    if (name.isEmpty() || !name.matches("[a-zA-Z]+")) // Sprawdź, czy nazwa użytkownika zawiera tylko litery
                    {
                        System.out.println("Invalid user name");
                        break;
                    }
                    Reader reader = new Reader(name);
                    library.add_user(reader);
                    break;

                case 3:
                    System.out.println("Enter user name: ");
                    String user_name = scanner.nextLine();
                    Reader user = library.find_user_by_name(user_name);
                    if (user == null)
                    {
                        System.out.println("User not found in the library");
                        break;
                    }
                    else
                    {
                        library.remove_user(user);
                        break;
                    }

                case 4:
                    System.out.println("Enter user name: ");
                    String user_name1 = scanner.nextLine();
                    Reader user1 = library.find_user_by_name(user_name1);
                    if (user1 == null)
                    {
                        System.out.println("User not found in the library");
                        break;
                    }
                    System.out.println("Enter book title: ");
                    String title1 = scanner.nextLine();
                    System.out.println("Enter book author: ");
                    String author1 = scanner.nextLine();
                    Book book1 = library.find_book_by_author_and_title(author1, title1);
                    if (book1 == null)
                    {
                        System.out.println("Book not found in the library");
                        break;
                    }
                    user1.reader_borrow_book(book1);
                    break;

                case 5:
                    System.out.println("Enter user name: ");
                    String user_name2 = scanner.nextLine();
                    Reader user2 = library.find_user_by_name(user_name2);
                    if (user2 == null)
                    {
                        System.out.println("User not found in the library");
                        break;
                    }
                    System.out.println("Enter book title: ");
                    String title2 = scanner.nextLine();
                    System.out.println("Enter book author: ");
                    String author2 = scanner.nextLine();
                    Book book2 = library.find_book_by_author_and_title(author2, title2);
                    if (book2 == null)
                    {
                        System.out.println("Book not found in the library");
                        break;
                    }
                    user2.reader_return_book(book2);
                    break;

                case 6:
                    library.display_books();
                    break;

                case 7:
                    library.display_users();
                    break;

                case 8:
                    System.out.println("Enter user name: ");
                    String user_name3 = scanner.nextLine();
                    Reader user3 = library.find_user_by_name(user_name3);
                    if (user3 == null )
                    {
                        System.out.println("User not found in the library");
                        break;
                    }
                    else
                    {
                        System.out.println("Books borrowed by " + user3.get_reader_name() + ": " + user3.get_borrowed_books());
                        break;
                    }

                case 9:
                    System.out.println("Enter book title: ");
                    String title3 = scanner.nextLine();
                    System.out.println("Enter book author: ");
                    String author3 = scanner.nextLine();
                    Book found_book = library.find_book_by_author_and_title(author3, title3);
                    if (found_book == null)
                    {
                        System.out.println("Book not found in the library");
                        break;
                    }
                    else
                    {
                        System.out.println("Number of copies: " + found_book.get_number_of_available_copy());
                        break;
                    }

                case 10:
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
        scanner.close();
    }
}
