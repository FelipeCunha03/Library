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

    List<Borrowings> listBorrowing = new ArrayList();

    public List<Borrowings> borrowBook() throws IOException {

        Borrowings borredBook = null;
        Book myBook = null;

        controllerBook myCB = new controllerBook();

        myBook = myCB.searchBookByTitle();

        for (int i = 0; i < controllerBook.listBook.size(); i++) {

            if (controllerBook.listBook.get(i).isIsAvailable() == true) {

                controllerBook.listBook.get(i).setIsAvailable(false);
                myBook = controllerBook.listBook.get(i);
            } else {
                System.out.println("Book is not avalable!");
                return null;
            }
        }

        controllerStudent myCS = new controllerStudent();
        Student myStudent;

        myStudent = myCS.searchStudentByID();

        String data = "01/01/2023";

        Borrowings myBorred = new Borrowings(myBook, myStudent, data);
        listBorrowing.add(myBorred);

        return listBorrowing;
    }

    public static void returnBook() {
        System.out.println("Return book method");

    }

    public static void listBookBorrowed() {
        System.out.println("List book borrowed method");

    }
}
