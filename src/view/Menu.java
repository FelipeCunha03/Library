/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import Control.controllerBorrowing;
import Control.controllerStudent;
import Control.cotrollerBook;
import java.util.Scanner;

/**
 *
 * @author rapha
 */
public class Menu {
    
    public static void main(String[] args){
    
        boolean valid;
        int option;
        
        Scanner myScanner = new Scanner (System.in);
        cotrollerBook myCB = new cotrollerBook();
        controllerStudent myCS = new controllerStudent();
        controllerBorrowing myBw = new controllerBorrowing();
        String bookTitle, bookAuthor;
   
        
        do{
            
            valid = false;
            
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
               
            System.out.println("\n==> Please enter your option: ");
            
            option = myScanner.nextInt();
            
            switch (option){
                
                case (1):
                    System.out.println("Inform the book title: ");  
                    bookTitle = myScanner.nextLine().trim();
                    
                    myCB.searchBookTitle(bookTitle);
                    break;
                    
                case (2):
                    System.out.println("Inform the author's name: ");  
                    bookAuthor = myScanner.nextLine().trim();
                    
                    myCB.searchBookAuthor();
                    break;
                    
                case (3):
                    myCB.listBookTitle();
                    break;
                case (4):
                    myCB.listBookAuthor();
                    break;
                case (5):
                    myCS.searchStudentName();
                    break;
                case (6):
                    myCS.searchStudentID();
                    break;
                case (7):
                    myCS.listStudentName();
                    break;
                case (8):
                    myCS.listStudentID();
                    break;
                case (9):
                    myBw.borrowBook();
                    break;
                case (10):
                    myBw.returnBook();
                    break;
                case (11):
                    myBw.listBookBorrowed();
                    break;
                case (12): 
                    System.out.println("-The program end.-");                        
                    break;  
                               
            }
            if (option < 1 || option > 12){ 
                System.out.println("Type a valid option please.");
            }
            valid = true;
        }while(!valid);
    }
    

}
