/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

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
        
        do{
            
            valid = false;
            
            System.out.println("--Welcome to CCT Library!!--");
            System.out.println("Choose one option: \n");
            System.out.println("1. Search for a specific book by title;");
            System.out.println("2. Search for a specific book by author;");
            System.out.println("3. List all books by title;");
            System.out.println("4. List all books by author name");
            System.out.println("5. Search for a specific student by name;");
            System.out.println("6. Search for a specific student by ID;");
            System.out.println("7. List all students by name;");
            System.out.println("8. List all students by ID;");
            System.out.println("9. Register a student has borrowed a book;");
            System.out.println("10. Register a student has returned a book; ");
            System.out.println("11. List the books borrowed by a specific student");         
            System.out.println("12. Exit");
               
            System.out.println("\nPlease enter your option: ");
            
            option = myScanner.nextInt();
            
            switch (option){
                
                case (1):
                //    searchBookTitle();
                    break;
                case (2):
                //    searchBookAuthor();
                    break;
                case (3):
                //    listBookTitle();
                    break;
                case (4):
                //    listBookAuthor();
                    break;
                case (5):
                //    searchStudentName();
                    break;
                case (6):
                //    searchStudentID();
                    break;
                case (7):
                //    listStudentName();
                    break;
                case (8):
                //    listStudentID();
                    break;
                case (9):
                //    borrowBook();
                    break;
                case (10):
                //    returnBook();
                    break;
                case (11):
                //    listBookBorrowed;
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
