/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import Controller.controllerBorrowing;
import Controller.controllerStudent;
import Controller.controllerBook;
import Model.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author rapha
 */
public class Menu {

    public static void main(String[] args) {

        int option = 0;

        Scanner myScanner = new Scanner(System.in);
        controllerBook myCB = new controllerBook();
        controllerStudent myCS = new controllerStudent();
        controllerBorrowing myBw = new controllerBorrowing();
        List<Book> listBook = new ArrayList<>();
        String bookAuthor;

        do {

            try {
                System.out.println("**********************************************************");
                System.out.println("**                 Welcome to CCT Library!!             **");
                System.out.println("**********************************************************");
                System.out.println("**  Choose one option:                                  **");
                System.out.println("**                                                      **");
                System.out.println("**  1. Search for a specific book by title;             **");
                System.out.println("**  2. Search for a specific book by author;            **");
                System.out.println("**  3. List all books by title;                         **");
                System.out.println("**  4. List all books by author name                    **");
                System.out.println("**  5. Search for a specific student by name;           **");
                System.out.println("**  6. Search for a specific student by ID;             **");
                System.out.println("**  7. List all students by name;                       **");
                System.out.println("**  8. List all students by ID;                         **");
                System.out.println("**  9. Register a student has borrowed a book;          **");
                System.out.println("**  10. Register a student has returned a book;         **");
                System.out.println("**  11. List the books borrowed by a specific student   **");
                System.out.println("**  12. Exit                                            **");
                System.out.println("**********************************************************");
                System.out.println("**********************************************************");
                System.out.println("===> Enter with the option: ");
                
          

                option = myScanner.nextInt();

                switch (option) {

                    case 1:

                        listBook = myCB.getBookObj();
                        System.out.println(myCB.searchBookByTitle(listBook));
                        break;

                    case 12:
                        System.out.println("The programar is over!");
                        break;

                    default:
                        System.out.println("Wrong option");

                }

            } catch (Exception e) {
                System.out.println("ERROR! You have to type just numbers and one of option on menu!");
                myScanner.nextLine();

            }

        } while (option != 12);

    }

}
