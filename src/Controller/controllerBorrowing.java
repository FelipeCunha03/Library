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
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.xml.crypto.Data;

/**
 *
 * @author rapha
 */
public class controllerBorrowing {

    Scanner s = new Scanner(System.in);
    controllerBook myCB = new controllerBook();
    controllerStudent myCS = new controllerStudent();
    List<Borrowings> listBorrowing = new ArrayList();

    public List<Borrowings> borrowBook() throws IOException {

        String titleBook;
        myCB.getBookObj();
        myCS.getStudentObj();
        Borrowings borredBook = null;
        Book myBook = null;

        System.out.println("Inform the book's title: ");
        String bookTitle = s.nextLine().trim();

        for (int i = 0; i < myCB.listBook.size(); i++) {

            if (myCB.listBook.get(i).getBookTitle().equals(bookTitle)) {

                if (myCB.listBook.get(i).isIsAvailable() == true) {

                    myCB.listBook.get(i).setIsAvailable(false);

                    myBook = myCB.listBook.get(i);

                } else {
                    System.out.println("Book is borred !");
                }

            }

        }
        
       Student myStudent = null;
       System.out.println("Informe the Students's ID: ");
       int idStudent = s.nextInt();
       
       for (int j = 0; j < myCS.listStudent.size(); j++) {

            if (myCS.listStudent.get(j).getIdStudent() == idStudent ) {
                
                   myStudent = myCS.listStudent.get(j);

                }

        }

             String data = "01/01/1023";
             Borrowings myBookBoored = new  Borrowings(myBook,myStudent,data);
             
             listBorrowing.add(myBookBoored);
       
        return listBorrowing;
    }

    public static void returnBook() {
        System.out.println("Return book method");

    }

    public static void listBookBorrowed() {
        System.out.println("List book borrowed method");

    }
}
