/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author felipecunha
 */
public class Book {
    
    // Atribute of Book.
    private String idBook;
    private String  firstNameAuthor;
    private String  lastNameAuthor;
    private String  bookTitle;
    private String  genre;
    private boolean  isAvailable;

    
    // Constructor

    public Book(String idBook, String firstNameAuthor, String lastNameAuthor, String bookTitle, String genre) {
        this.idBook = idBook;
        this.firstNameAuthor = firstNameAuthor;
        this.lastNameAuthor = lastNameAuthor;
        this.bookTitle = bookTitle;
        this.genre = genre;
        this.isAvailable = true;
 
    }
    
    
    // methodos gets and setters 

    public String getIdBook() {
        return idBook;
    }

    public void setIdBook(String idBook) {
        this.idBook = idBook;
    }

   

    public String getFirstNameAuthor() {
        return firstNameAuthor;
    }

    public void setFirstNameAuthor(String firstNameAuthor) {
        this.firstNameAuthor = firstNameAuthor;
    }

    public String getlastNameAuthor() {
        return lastNameAuthor;
    }

    public void setlastNameAuthor(String LastNameAuthor) {
        this.lastNameAuthor = LastNameAuthor;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

   

    public boolean isIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
   
    
    // methodos toString  for output the book as String.

    @Override
    public String toString() {
        return  "IdBook: " + idBook + ", First Name of Author: " + firstNameAuthor + ", LastName of Author: " + lastNameAuthor + ", Title of book: " + bookTitle + ", Genre: " + genre + ", Available: " + isAvailable + "\n";
    }

    
    
    
    
    
    
}
