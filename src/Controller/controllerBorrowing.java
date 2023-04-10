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
import java.util.List;
import java.util.Optional;
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

    public Borrowings borrowBook() {

        Borrowings borredBook = null; //
        Book myBook = null; //

        controllerBook myCB = new controllerBook();
        controllerStudent myCS = new controllerStudent();

        //call the method to search book by title
        myBook = myCB.searchBookByTitle();
        if (myBook == null) {
            System.out.println("Book was not found!");
            return null;
        }
        //check if the book is avaiable to be borrowed
        if (myBook.isIsAvailable() == true) {
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

            //Borrowings borredByStudent = new Borrowings(myBook, myStudent);
            //listBorrowingByStudent.add(borredByStudent);
            //return the book borrowed
            return myBorred;

            //if the book is not avaiable to be borrowed, ask the user about go to the queue
        } else {
            System.out.println("Book is borrowed. Would you like to wait on the queue for the book? S/N");
            String answer = s.nextLine().toLowerCase();

            if (answer.equals("s")) {
                waitListQueue();

            }

            //if the book is borrowed and user doesn't want to wait on the queue, return null
            return null;

        }

    }

    public void waitListQueue() {

    }

    public static void returnBook() {
        System.out.println("Return book method");

    }

    public List<Borrowings> listBookBorrowed() {
        System.out.println("*************List of Books Borrowed*************");
        return listBorrowing;
    }

    public List<Book> listBookBorrowedByStudent() {

        controllerStudent myCS = new controllerStudent();
        List<Book> listAux = new ArrayList();

        myStudent = myCS.searchStudentByID();

        for (int i = 0; i < listBorrowing.size(); i++) {
            
            if (myStudent.getIdStudent() == listBorrowing.get(i).getMyStudent().getIdStudent()) {

                listAux.add(listBorrowing.get(i).getMyBook());
            }
        }

        System.out.println("*************List of Books Borrowed by Student*************");

        return listAux;
    }

}
