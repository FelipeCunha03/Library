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
    private String  idBook;
    private String  fNameAuthor;
    private String  lNameAuthor;
    private String  bookTitle;
    private String  genre;
    private boolean isAvailable;

    
    // Constructor

    public Book(String idBook, String fNameAuthor, String lNameAuthor, String bookTitle, String genre) {
        this.idBook = idBook;
        this.fNameAuthor = fNameAuthor;
        this.lNameAuthor = lNameAuthor;
        this.bookTitle = bookTitle;
        this.genre = genre;
        this.isAvailable = true;
    }

    public String getIdBook() {
        return  idBook;
    }

    public void setIdBook(String idBook) {
        this.idBook = idBook;
    }

    public String getfNameAuthor() {
        return fNameAuthor;
    }

    public void setfNameAuthor(String fNameAuthor) {
        this.fNameAuthor = fNameAuthor;
    }

    public String getlNameAuthor() {
        return lNameAuthor;
    }

    public void setlNameAuthor(String lNameAuthor) {
        this.lNameAuthor = lNameAuthor;
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

    // methodos gets and setters
    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    // methodos toString  for output the book as String.
    @Override
    public String toString() {
        return  "\n-------Detains of book -------\nId Book: " + idBook +
                "\nAuthor's first name: " + fNameAuthor +
                "\nAuthor's last name: " + lNameAuthor +
                "\nBook's title: " + bookTitle +
                "\nGenre: " + genre + 
                "\nAvailable: " + isAvailable + "\n"
                + "-------------------------";
    }

    
    
    
    
    
    
}
