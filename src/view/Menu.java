/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import Controller.ControllerAvailabilityBook;
import Controller.ControllerBorrow;
import Controller.ControllerStudent;
import Controller.ControllerBook;
import Model.Book;
import Model.Borrow;
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
// teste
    public static void main(String[] args) throws IOException {

        Scanner s = new Scanner(System.in);
        ControllerBook myCB = new ControllerBook();
        ControllerStudent myCS = new ControllerStudent();
        ControllerBorrow myBW = new ControllerBorrow();
         ControllerAvailabilityBook myCAB = new ControllerAvailabilityBook();
        //String bookDetails = "---------------Book's details --------------";
        int option = 0;

        // calling the methot that will get the file data of books/students/generateAvailableBook 
        myCB.getBookObj();
        myCS.getStudentObj();
        myCB.generateAvailableBook();
        myCAB.gererateAvailabilityBookFile();
        

        do {

            try {
                System.out.println("**********************************************************");
                System.out.println("**                 Welcome to CCT Library!!             **");
                System.out.println("**********************************************************");
                System.out.println("**  Choose one option:                                  **");
                System.out.println("**                                                      **");
                System.out.println("**  1. Search for a specific book by title              **");
                System.out.println("**  2. Search for a specific book by author             **");
                System.out.println("**  3. List all books by title                          **");
                System.out.println("**  4. List all books by author's name                  **");
                System.out.println("**  5. Search for a specific student by name            **");
                System.out.println("**  6. Search for a specific student by ID              **");
                System.out.println("**  7. List all students by name                        **");
                System.out.println("**  8. List all students by ID                          **");
                System.out.println("**  9. Register that a student has borrowed a book      **");
                System.out.println("** 10. Register a student has returned a book           **");
                System.out.println("** 11. List all the books borrowed                      **");
                System.out.println("** 12. List the books borrowed by a specific student    **");
                System.out.println("** 13. List the students waiting on the queue           **");
                System.out.println("** 14. Check book availability                          **");
                System.out.println("** 15. Exit                                             **");
                System.out.println("**********************************************************");
                System.out.println("**********************************************************");
                System.out.println("===> Enter with the option: ");

                option = s.nextInt();

                switch (option) {

                    case 1:
                        Book myBook = myCB.searchBookByTitle();

                        if (myBook == null) {
                            System.out.println("Book was not found!");
                        } else {

                            System.out.println(myBook);
                        }
                        break;

                    case (2):
                        myBook = myCB.searchBookByAuthor();

                        if (myBook == null) {
                            System.out.println("Author was not found!");
                        } else {

                            System.out.println(myBook);
                        }
                        break;

                    case (3):

                        System.out.println(myCB.listBookByTitle());
                        break;

                    case (4):

                        System.out.println(myCB.listBookByAuthor());
                        break;

                    case (5):
                        Student myStudent = myCS.searchStudentByName();

                        if (myStudent == null) {
                            System.out.println("Student was not found!");
                        } else {
                            System.out.println(myStudent);
                        }
                        break;

                    case (6):
                        myStudent = myCS.searchStudentByID();

                        if (myStudent == null) {
                            System.out.println("ID was not found!");
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
                        
                        Borrow myBorrowing = myBW.borrowBook();

                        if (myBorrowing == null) {
                            s.nextLine();
                        } else {
                            System.out.println(myBorrowing);
                        }
                        break;

                    case (10):
                        myBW.returnBook();
                        break;

                    case (11):
                        System.out.println(myBW.listBookBorrowed());
                        break;

                    case (12):
                        List<Book> booksByStudent = myBW.listBookBorrowByStudent();

                        if (booksByStudent == null) {
                            System.out.println("This student has not borrowed any book.\n");
                        } else {
                            System.out.println(booksByStudent);
                        }
                        break;

                    case (13):
                        myBW.listStudentsQueue();

//                        if (studentQueue == null) {
//                            System.out.println("There is no student waiting on the queue.\n");
//                        }else{
//                            System.out.println(studentQueue);
//                        }                 
                        break;

                    case (14):
                        
                       
                        boolean check = myCAB.checkBookAvailability(); 
                        if( check == true){
                            System.out.println("Book is available");
                        }else{
                            System.out.println("Book is borrowed");
                        }

                        break;
                    case (15):
                        System.out.println("The programar is over!");
                        break;

                    default:
                        System.out.println("Please, choose an option between 1 and 12.");
                }

            } catch (Exception e) {
                System.out.println("Sorry, something wrong has happened :( \nMessage error: " + e.getMessage());
                s.nextLine();
            }
        } while (option != 13);
    }
}
