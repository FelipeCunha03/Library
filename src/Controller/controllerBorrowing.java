/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Book;
import Model.Borrowings;
import Model.Student;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import javax.xml.crypto.Data;

/**
 *
 * @author rapha
 */
public class controllerBorrowing {

    Scanner s = new Scanner(System.in);

    List<Borrowings> listBorrowing = new ArrayList();
    List<Borrowings> listBorrowingbyStudent = new ArrayList();
    
    public Borrowings borrowBook(){
        
        Borrowings borredBook = null; //
        Book myBook = null; //
        Student myStudent;
        
        controllerBook myCB = new controllerBook();
        controllerStudent myCS = new controllerStudent();
        
        //call the method to search book by title
        myBook = myCB.searchBookByTitle();
        
        //check if the book is avaiable to be borrowed
        if (myBook.isIsAvailable()==true){
            myBook.setIsAvailable(false);
            
            //call the method to search student by ID
            myStudent = myCS.searchStudentByID();

            //save the data and time the book is borrowed
            LocalDateTime localTime = LocalDateTime.now();
            DateTimeFormatter dataFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");       
            String dataBorrowed = localTime.format(dataFormat);
            
            //when the book is borrowed, there is no data returned
            LocalDateTime dReturned = null;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            Optional<LocalDateTime> optionalDate = Optional.ofNullable(dReturned);
            String dataReturned = optionalDate.map(formatter::format).orElse(" ");
            
            //save the book that was borrowed and send the information and include it to the borrowing's list
            Borrowings myBorred = new Borrowings(myBook, myStudent, dataBorrowed, dataReturned);
            listBorrowing.add(myBorred);
            
            //return the book borrowed
            return myBorred;
        
        //if the book is not avaiable to be borrowed, ask the user about go to the queue
        }else{
            System.out.println("Book is borrowed. Would you like to wait on the queue for the book? S/N");
            String answer = s.nextLine();
            
            if (answer.equals("S")|| answer.equals("s")){              
                //student goes to the queue
                //return confirmed     
                System.out.println("Confirmed! You are on the queue :) ");
            }
        //if the book is borrowed and user doesn't want to wait on the queue, return null
        return null;    
        }
   
    }

    public static void returnBook() {
        System.out.println("Return book method");

    }

    public List<Borrowings> listBookBorrowed() {
        System.out.println("*************List of Books Borrowed*************");
        return listBorrowing;
    }
    
    public List<Borrowings> listBookBorrowedByStudent() {
                
        Student myStudent;
        controllerStudent myCS = new controllerStudent();

        myStudent = myCS.searchStudentByID();
        
        //Borrowings studentBorrowed = new Borrowings(myStudent);
        
        System.out.println("*************List of Books Borrowed by Student*************");
        
        return listBorrowingbyStudent;
    }
}