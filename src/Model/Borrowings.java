/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author rapha
 */
public class Borrowings {
    
    private int idborrowing;
    private Book myBook;
    private Student myStudent;
    private Date dateborrowing;
    private Date datereturned;

    public Borrowings(int idborrowing, Book myBook, Student myStudent, Date dateborrowing, Date datereturned) {
        this.idborrowing = idborrowing;
        this.myBook = myBook;
        this.myStudent = myStudent;
        this.dateborrowing = dateborrowing;
        this.datereturned = datereturned;
    }

    public int getIdborrowing() {
        return idborrowing;
    }

    public void setIdborrowing(int idborrowing) {
        this.idborrowing = idborrowing;
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

    public Date getDateborrowing() {
        return dateborrowing;
    }

    public void setDateborrowing(Date dateborrowing) {
        this.dateborrowing = dateborrowing;
    }

    public Date getDatereturned() {
        return datereturned;
    }

    public void setDatereturned(Date datereturned) {
        this.datereturned = datereturned;
    }

    @Override
    public String toString() {
        return "Borrowings{" + "idborrowing=" + idborrowing + ", myBook=" + myBook + ", myStudent=" + myStudent + ", dateborrowing=" + dateborrowing + ", datereturned=" + datereturned + '}';
    }
    
   

    
    
}
