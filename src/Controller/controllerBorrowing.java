/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import static Controller.controllerStudent.listStudent;
import Model.Book;
import Model.Borrowings;
import Model.Student;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;
import java.util.Scanner;
import javax.xml.crypto.Data;
import javax.xml.transform.Source;

/**
 *
 * @author rapha
 */
public class controllerBorrowing {

    Scanner s = new Scanner(System.in);

    List<Borrowings> listBorrowing = new ArrayList();

    static List<Borrowings> listBorrowingByStudent = new ArrayList();
    Student myStudent;
    Book myBook;
    Borrowings borredBook, myStudentQueue;
    controllerBook myCB = new controllerBook();
    LocalDateTime localTime;
    String dataReturned, dataBorrowed;
    Queue<Borrowings> myQ = new LinkedList<>(); 
    

    public Borrowings borrowBook() {
       
        controllerStudent myCS = new controllerStudent();

        //call the method to search book by title
        myBook = myCB.searchBookByTitle();
        if (myBook == null) {
            System.out.println("Book was not found!");
            return null;
        }
        //call the method to search student by ID
        myStudent = myCS.searchStudentByID();
        if (myStudent == null) {
            System.out.println("Student was not found!");
        return null;
        }
        
        //check if the book is avaiable to be borrowed
        if (myBook.isIsAvailable() == true) {
                    
            myBook.setIsAvailable(false);

            //save the data and time the book is borrowed
            localTime = LocalDateTime.now();
            DateTimeFormatter dataFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            dataBorrowed = localTime.format(dataFormat);

            //when the book is borrowed, there is no data returned
            LocalDateTime dReturned = null;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            Optional<LocalDateTime> optionalDate = Optional.ofNullable(dReturned);
            dataReturned = optionalDate.map(formatter::format).orElse(" --- ");

            //save the book that was borrowed and send the information and include it to the borrowing's list
            Borrowings myBorred = new Borrowings(myBook, myStudent, dataBorrowed, dataReturned);
            listBorrowing.add(myBorred);

            //return the book borrowed
            System.out.println(" \n***Confirmed the borrowing of the book to the student***\n");
            return myBorred;

            //if the book is not avaiable to be borrowed, ask the user about go to the queue
        } else {
            System.out.println("Book is borrowed. Would you like to wait on the queue for the book? S/N");
            String answer = s.nextLine().toLowerCase();

            if (answer.equals("s")){  
                myStudentQueue = new Borrowings(myBook, myStudent, dataBorrowed, dataReturned);
                myQ.add(myStudentQueue);
                     
                System.out.println("\n***Confirmed! The student " + myStudent.getfNameStudent()+
                        " " + myStudent.getlNameStudent()+ " is on the queue for the book " +
                        myBook.getBookTitle() + "***\n");                            
            }

            //System.out.println("tamanho da fila: " +myQ.size());
        
        return null;           
        } 

    }

//    public void waitingListQueue() {
//
//    }

    public Borrowings returnBook() {
        myBook = myCB.searchBookByTitle();
        
        if (myBook == null){
            System.out.println("Book was not found!");
            return null;
        }
        
        if (myBook.isIsAvailable()== false){
            myBook.setIsAvailable(true);
            
            localTime = LocalDateTime.now();
            DateTimeFormatter dataFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");       
            dataReturned = localTime.format(dataFormat);       
            
            System.out.println("\n***Book returned!***");
            System.out.println("Returned date: " + dataReturned + "\n");
            System.out.println("The next student waiting for this book is: " + myQ.peek().getMyStudent().getfNameStudent() +
                                " " + myQ.peek().getMyStudent().getlNameStudent() + "\n");
            
        }else{
            System.out.println("Book is not borrowed. You can borrow it using option 9.\n");
        }
        
        return null;
    }

    public List<Borrowings> listBookBorrowed() {
        System.out.println("\n*************LIST OF BOOKS BORROWED*************");
        return listBorrowing;
    }

    public List<Book> listBookBorrowedByStudent() {

        controllerStudent myCS = new controllerStudent();
        List<Book> listAux = new ArrayList();
        int count = 0;
        myStudent = myCS.searchStudentByID();

        for (int i = 0; i < listBorrowing.size(); i++) {
            
            if (myStudent.getIdStudent() == listBorrowing.get(i).getMyStudent().getIdStudent()) {
                listAux.add(listBorrowing.get(i).getMyBook());
                count++;         
            }else{
                return null;
            }
        }
        if (count == 0){
            return null;
        }else{
            System.out.println("\n*************LIST OF BOOKS BORROWED BY STUDENT*************");
            System.out.println("Student: " + myStudent.getfNameStudent() + " " + myStudent.getlNameStudent());
            return listAux;
        }
    }

}
