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
    private String idAuthor;
    private String  firstNameAuthor;
    private String  LastNameAuthor;
    private String  bookTitle;
    private String  genero;
    //private boolean isBorrowed;
    
    // Constructor

    public Book(String idAuthor, String firstNameAuthor, String LastNameAuthor, String bookTitle, String genero) {
        this.idAuthor = idAuthor;
        this.firstNameAuthor = firstNameAuthor;
        this.LastNameAuthor = LastNameAuthor;
        this.bookTitle = bookTitle;
        this.genero = genero;
        //this.isBorrowed = isBorrowed;
    }
    
    
    // methodos gets and setters 

    public String getId() {
        return idAuthor;
    }



    public void setId(String id) {
        this.idAuthor = id;
    }

    public String getFirstNameAuthor() {
        return firstNameAuthor;
    }

    public void setFirstNameAuthor(String firstNameAuthor) {
        this.firstNameAuthor = firstNameAuthor;
    }

    public String getLastNameAuthor() {
        return LastNameAuthor;
    }

    public void setLastNameAuthor(String LastNameAuthor) {
        this.LastNameAuthor = LastNameAuthor;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

   /* public boolean isisBorrowed() {
        return isBorrowed;
    }

    public void setStatus(boolean isBorrowed) {
        this.isBorrowed = isBorrowed;
    }*/
    
 
    
    
    // methodos toString  for output the book as String.

    @Override
    public String toString() {
        return "Book{" + "id=" + idAuthor + ", firstNameAuthor=" + firstNameAuthor + ", LastNameAuthor=" + LastNameAuthor + ", bookTitle=" + bookTitle + ", genero=" + genero + '}' +"\n";
    }
    
    
    
    
    
}
