/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import static Controller.ControllerStudent.listStudent;
import Model.Book;
import Model.Borrow;
import Model.Student;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;


/**
 *
 * @author rapha
 */
public class ControllerBorrow {

    Scanner s = new Scanner(System.in);

    List<Borrow> listBorrowed = new ArrayList();
    static List<Borrow> ListBookByStudent = new ArrayList();
    Student myStudent;
    Book myBook;
    ControllerBook myCB = new ControllerBook();
    ControllerStudent myCS = new ControllerStudent();
    LocalDateTime localTime;
    String dataReturned, dataBorrowed;
    Map <Book, CustomizedQueue<Integer>> myMap = new HashMap<>();
    CustomizedQueue<Integer> myQueue;
    
    
    public Borrow borrowBook() {
        
        myQueue = new CustomizedQueue(100);     
        
        //call the method to search book by title
        myBook = myCB.searchBookByTitle();
        if (myBook == null) {
            messageError("Book");
            return null;
        }
      
        //call the method to search student by ID
        myStudent = myCS.searchStudentByID();
        if (myStudent == null) {
            messageError("Student");
            return null;
        }
          
        //check if the book is available to be borrowed
        for (int i = 0; i < ControllerBook.listAvailableBook.size(); i++){
            
            if (ControllerBook.listAvailableBook.get(i).getIdBook().equals(myBook.getIdBook())
                    && ControllerBook.listAvailableBook.get(i).isIsAvailable() == true) {
                
                //check if the map is not empty     
                if (myMap.get(myBook) != null){ 
                    //if the student who wants borrow the book is the first of the queue waiting, remove this student of the queue and let him borrow it
                    if (myStudent.getIdStudent() == myMap.get(myBook).getFirstStudentOfQueue()){
                        myMap.get(myBook).RemoveStudentQueue(myStudent.getIdStudent());
                        
                    }else{//if not, don't let the student borrow the book and show a message with the name of the first on the queue
                        
                        for (int j=0; j < listStudent.size(); j++){//for to return the name of the student 
                            
                            if (listStudent.get(j).getIdStudent()== myMap.get(myBook).getFirstStudentOfQueue()){                               
                                System.out.println("The book is not available to you yet because the first student of the queue is: " + listStudent.get(j).getfNameStudent() + " " + listStudent.get(j).getlNameStudent()+ " - id student: "
                                                    + myMap.get(myBook).getFirstStudentOfQueue()+ ".");
                                return null;
                            }
                        }
                    }              
                }               
                ControllerBook.listAvailableBook.get(i).setIsAvailable(false);

                ControllerAvailabilityBook myCAB = new ControllerAvailabilityBook();
                myCAB.gererateAvailabilityBookFile(); // call the methodo that overwrite the file AvailabilityBookFile that show the status of book.

                localTime = LocalDateTime.now();
                DateTimeFormatter dataFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                dataBorrowed = localTime.format(dataFormat);  //save the data and time the book is borrowed

                //when the book is borrowed, there is no data returned
                LocalDateTime dReturned = null;
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                Optional<LocalDateTime> optionalDate = Optional.ofNullable(dReturned);
                dataReturned = optionalDate.map(formatter::format).orElse(" --- ");

                //save the book that was borrowed and send the information and include it to the borrowing's list
                Borrow myBorred = new Borrow(myBook.getIdBook(),myBook.getBookTitle(),myStudent.getIdStudent(),
                    myStudent.getfNameStudent(),myStudent.getlNameStudent(),dataBorrowed, dataReturned);

                listBorrowed.add(myBorred);
                storageListBorrowedFile();

                Borrow myBorredByStudent = new  Borrow( myStudent.getIdStudent(),myBook);
                ListBookByStudent.add(myBorredByStudent);

                //return the book borrowed
                System.out.println(" \n***Confirmed the borrowing of the book to the student***\n");
                return myBorred;

            }
        }                 
                //if the book is not avaiable to be borrowed, ask the user about go to the queue
                System.out.println("Book is borrowed. Would you like to wait on the queue for the book? S/N");
                String answer = s.nextLine().toLowerCase();

                if (answer.equals("s")) {
                    waitingListQueue();
                }
        return null;
    }

    public void waitingListQueue() {
         
        if (!myMap.containsKey(myBook)) {             
            myMap.put(myBook, myQueue);          
        }
        boolean myReturn = myMap.get(myBook).AddStudentQueue(myStudent.getIdStudent());
       
        if (myReturn == true){

                System.out.println("\n***Confirmed! The student " + myStudent.getfNameStudent() + " "
                       + myStudent.getlNameStudent() + " is on the queue for the book " + myBook.getBookTitle() + "***\n");
            }        
    }

     public void returnBook() {
         
        myBook = myCB.searchBookByTitle();
        ControllerAvailabilityBook myCAB = new ControllerAvailabilityBook();

        if(myBook == null) {
            messageError("Book");
        }else{

            for (int i = 0; i < ControllerBook.listAvailableBook.size(); i++) {

                if (ControllerBook.listAvailableBook.get(i).getIdBook().equals(myBook.getIdBook())) {
                    
                    if (ControllerBook.listAvailableBook.get(i).isIsAvailable() == false) {

                        ControllerBook.listAvailableBook.get(i).setIsAvailable(true);
                        myCAB.gererateAvailabilityBookFile();

                        localTime = LocalDateTime.now();
                        DateTimeFormatter dataFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                        dataReturned = localTime.format(dataFormat);

                        System.out.println("\n*Book returned!*");
                        System.out.println("Returned date: " + dataReturned + "\n");
                         
                    }else{                      
                        System.out.println("Book is not borrowed!");        
                    }
                    
                    if (myMap.get(myBook) == null){
                        System.out.println("There is no student waiting on the queue.");
                    }else{    
                                           
                        for (int j=0; j < listStudent.size(); j++){
                            
                            if (listStudent.get(j).getIdStudent()== myMap.get(myBook).getFirstStudentOfQueue()){
                                
                                System.out.println("The first student waiting on the queue for this book is: " + listStudent.get(j).getfNameStudent() + " " + listStudent.get(j).getlNameStudent()+ " - id student: "
                                + myMap.get(myBook).getFirstStudentOfQueue()+ ".");
                            }
                        }
                    }        
                }   
            }
        }
    }
     
     
    public void listBookBorrowed() {
        if (listBorrowed.isEmpty() == true){
            System.out.println("There are no borrowed books.");
        }else{
            System.out.println("\n*************LIST ALL BOOKS BORROWED*************************\n");
            System.out.println(listBorrowed);
        }
    }

    public List<Book> listBookBorrowByStudent() {

        ControllerStudent myCS = new ControllerStudent();
        List<Book> listAux = new ArrayList();
        myStudent = myCS.searchStudentByID();

        for (int i = 0; i < ListBookByStudent.size(); i++) {

            if (myStudent.getIdStudent() == ListBookByStudent.get(i).getIdStudent()) {
                listAux.add(ListBookByStudent.get(i).getMyBook());
            }
        }      
        System.out.println("*************LIST OF BOOKS BORROWED BY STUDENT***************");
        System.out.println("\nStudent: " + myStudent.getfNameStudent() + " " + myStudent.getlNameStudent());
        System.out.println("\n***************   Book's details   ************************");
        return listAux;
        
    }
 
    // storge the list borrred in  file txt.
    public  void storageListBorrowedFile(){
        
        try {
            // try overwrite txt if something went wrong  will be have Exception
            BufferedWriter myWriter = new BufferedWriter(new FileWriter("src/library/Borrow_table.csv", false));

            for (int i =0; i<listBorrowed.size(); i++) {

                //  write in the TXT the arralist in reverse ordem.
                myWriter.write(listBorrowed.get(i) + "\n");
            }
            myWriter.close();

        }catch(Exception e) {
            System.out.println("Error writing on txt! ");
        }     
    }
    
    public void messageError(String objError){      
        System.out.println(objError +" was not found!");
    }
}
