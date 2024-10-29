package com.example;

import java.util.Scanner;


public class App 
{
    public static void main( String[] args )
    {
        Library library = new Library(null, null);
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
            System.out.println("9. number of books");
            System.out.println("10. exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Wyczyść bufor po nextInt(), aby uniknąć problemów przy następnym nextLine()
            switch (choice)
            {
                case 1: 
                    System.out.println("Enter book title: ");
                    String title = scanner.nextLine(); // Wczytuje pełen wiersz tytułu
                    System.out.println("Enter book author: ");
                    String author = scanner.nextLine(); // Wczytuje pełen wiersz autora
                    System.out.println("Enter book copies: ");
                    int copies = scanner.nextInt(); // Wczytuje liczbę kopii
                    scanner.nextLine(); // Wyczyść bufor po nextInt(), aby uniknąć problemów przy następnym nextLine()
                    Book book = new Book(title, author);
                    library.add_book(book, copies);
                    break;

                case 2: 
                    System.out.println("Enter user name: ");
                    String name = scanner.nextLine();
                    Reader reader = new Reader(name);
                    library.add_user(reader);
                    break;

                case 3:
                    System.out.println("Enter user name: ");
                    String user_name = scanner.nextLine();
                    Reader user = new Reader(user_name);
                    library.remove_user(user);
                    break;

                case 4:
                    System.out.println("Enter user name: ");
                    String user_name1 = scanner.nextLine();
                    Reader user1 = new Reader(user_name1);
                    System.out.println("Enter book title: ");
                    String title1 = scanner.nextLine();
                    System.out.println("Enter book author: ");
                    String author1 = scanner.nextLine();
                    Book book1 = new Book(title1, author1);
                    user1.reader_borrow_book(book1);
                    break;

                case 5:
                    System.out.println("Enter user name: ");
                    String user_name2 = scanner.nextLine();
                    Reader user2 = new Reader(user_name2);
                    System.out.println("Enter book title: ");
                    String title2 = scanner.nextLine();
                    System.out.println("Enter book author: ");
                    String author2 = scanner.nextLine();
                    Book book2 = new Book(title2, author2);
                    user2.reader_return_book(book2);
                    break;

                case 6:
                    System.out.println(library.get_books());
                    break;

                case 7:
                    System.out.println(library.get_user());
                    break;

                case 8:
                    //            

                case 9:
                    System.out.println("Enter book title: ");
                    String title3 = scanner.nextLine();
                    System.out.println("Enter book author: ");
                    String author3 = scanner.nextLine();
                    if(library.get_books().contains(new Book(title3, author3)))
                    {
                        System.out.println("Number of copies: " + library.get_books().get(library.get_books().indexOf(new Book(title3, author3))).get_copies());
                    }
                    else
                    {
                        System.out.println("This book is not in the library");
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
