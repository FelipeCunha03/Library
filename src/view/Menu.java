/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import Controller.controllerBorrowing;
import Controller.controllerStudent;
import Controller.controllerBook;
import Model.Book;
import Model.Borrowings;
import Model.Student;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author rapha
 */
public class Menu {

    public static void main(String[] args) throws IOException {

        int option = 0;

        Scanner s = new Scanner(System.in);
        controllerBook myCB = new controllerBook();
        controllerStudent myCS = new controllerStudent();
        controllerBorrowing myBw = new controllerBorrowing();

    
        // calling the methot that will get the file data of books/students!
          myCB.getBookObj();
          myCS.getStudentObj();
          
          
          

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
                System.out.println("**  9. Borrowe a book;                                  **");
                System.out.println("**  10. Register a student has returned a book;         **");
                System.out.println("**  11. List the books borrowed by a specific student   **");
                System.out.println("**  12. Exit                                            **");
                System.out.println("**********************************************************");
                System.out.println("**********************************************************");
                System.out.println("===> Enter with the option: ");

                option = s.nextInt();

                switch (option) {

                    case 1:
                        
                        Book myBook;
                        myBook = myCB.searchBookByTitle();
                        if (myBook == null) {
                            System.out.println("Book not found!");

                        } else {
                            System.out.println(myBook);
                        }
                        break;

                    case (2):

                        myBook = myCB.searchBookByAuthor();

                        if (myBook == null) {
                            System.out.println("Book not found!");

                        } else {
                            System.out.println(myBook);
                        }
                        break;

                    case (3):
                        //myCB.listBookTitle();
                        break;

                    case (4):
                        
                        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------");
                        System.out.println("List all books by author alphabetical  ");
                        System.out.println(myCB.listBookByAuthor());
                        break;

                    case (5):

                        Student myStudent;
                        myStudent = myCS.searchStudentByName();

                        if (myStudent == null) {
                            System.out.println("Student not found!");

                        } else {
                            System.out.println(myStudent);
                        }
                        break;

                    case (6):

                        myStudent = myCS.searchStudentByID();

                        if (myStudent == null) {
                            System.out.println("ID not found!");

                        } else {
                            System.out.println(myStudent);
                        }
                        break;

                    case (7):
                        System.out.println(myCS.listStudentByName());                       
                        break;

                    case (8):                        
                        System.out.println(myCS.listStudentByID());                       
                        break;

                    case (9):
           
                            System.out.println(myBw.borrowBook());
                        
                        break;

                    case (10):
                        myBw.returnBook();
                        break;

                    case (11):
                        myBw.listBookBorrowed();
                        break;

                    case (12):
                        System.out.println("The programar is over!");
                        break;

                    default:
                        System.out.println("Please, choose an option between 1 and 12");

                }

            } catch (Exception e) {
                System.out.println("ERROR! JUST NUMBERS" + e.getMessage());
                s.nextLine();

            }

        } while (option != 12);

    }

}
