/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author rapha
 */
public class Borrowings {
    
    //private int idborrowing;
    private Book myBook;
    private Student myStudent;
    private LocalDateTime dateborrowing;
    //private Date datereturned;

    public Borrowings(Book myBook, Student myStudent, LocalDateTime dateborrowing) {
        this.myBook = myBook;
        this.myStudent = myStudent;
        this.dateborrowing = dateborrowing;
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

    public LocalDateTime getDateborrowing() {
        return dateborrowing;
    }

    public void setDateborrowing(LocalDateTime dateborrowing) {
        this.dateborrowing = dateborrowing;
    }

    @Override
    public String toString() {
        return "Borrowings{" + "myBook=" + myBook + ", myStudent=" + myStudent + ", dateborrowing=" + dateborrowing + '}';
    }



    
   

    
    
}
