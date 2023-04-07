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
import java.util.List;
import java.util.Scanner;
import javax.xml.crypto.Data;

/**
 *
 * @author rapha
 */
public class controllerBorrowing {
    
    Scanner s = new Scanner(System.in);
    String titleBook;
    Book myBook;
    int idStudent;
    controllerBook myCB = new controllerBook();
    controllerStudent myCS = new controllerStudent();
    List<Borrowings> listBorrowing;
    
          
    
    
    public Borrowings borrowBook() throws IOException{
         myCB.getBookObj();
         myCS.getStudentObj();

        //System.out.println("Inform the book's name to be borrowed:");
       // myCB.searchBookByTitle();
        titleBook = s.nextLine().trim();
        //System.out.println("Inform the student's id:");
       // idStudent = s.nextInt();
       
         myBook = myCB.searchBookByTitle();
        
                if (myBook.isIsAvailable()== true){
                   
 //                   listBorrowing.get(i).setMyBook(myBook);
                    System.out.println("teste do livro rapha" + myBook); 
   //                 listBorrowing.get(i).setDateborrowing(LocalDateTime.MIN);
   
                    //listBorrowing.get(i).setDateborrowing(now);
   
                     System.out.println("teste do livro rapha" + myBook);        
  
                }else{
                    System.out.println("Book is not avaialable to be borrowed.");
                }   
  
         
        return null;
    }
        
        
          
    public static void returnBook(){
        System.out.println("Return book method"); 

    }
    public static void listBookBorrowed(){
        System.out.println("List book borrowed method"); 

    }
}

