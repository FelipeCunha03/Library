/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author rapha
 */
public class Borrowings {

    //private int idborrowing;
    private Book myBook;
    private Student myStudent;
    private String dataBorrowing;
    private String dataReturned;

    public Borrowings(Book myBook, Student myStudent, String dataBorrowing, String dataReturned) {
        this.myBook = myBook;
        this.myStudent = myStudent;
        this.dataBorrowing = dataBorrowing;
        this.dataReturned = dataReturned;
    }

    public Book getMyBook() {
        return myBook;
    }

    public void setMyBook(Book myBook) {
        this.myBook = myBook;
    }

    public Student getMyStudent() {
        return myStudent;
    }

    public void setMyStudent(Student myStudent) {
        this.myStudent = myStudent;
    }

    public String getDataBorrowing() {
        return dataBorrowing;
    }

    public void setDataBorrowing(String dataBorrowing) {
        this.dataBorrowing = dataBorrowing;
    }

    public String getDataReturned() {
        return dataReturned;
    }

    public void setDataReturned(String dataReturned) {
        this.dataReturned = dataReturned;
    }

    public String toString() {
        return ""
                + myBook
                + "\n" + myStudent
                + "\nBorrowed date: " + dataBorrowing + "\n--------------------------------------------"
                + "\nReturned date: " + dataReturned + "\n--------------------------------------------";
    }

}
