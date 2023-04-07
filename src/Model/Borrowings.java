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
    private String dateborrowing;
    //private Date datereturned;

    public Borrowings(Book myBook, Student myStudent, String dateborrowing) {
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

    public String getDateborrowing() {
        return dateborrowing;
    }

    public void setDateborrowing(String dateborrowing) {
        this.dateborrowing = dateborrowing;
    }

  
     
    public String toString() {
        return  "\n-------List of books Borred -------\n" + 
                 myBook +
                "\n Students's details has borred  " + myStudent +
                "\n Data de emprestimo: " + dateborrowing +"\n"+
               "-------------------------";
    }

   




    
   

    
    
}
