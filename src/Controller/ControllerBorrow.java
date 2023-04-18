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

     public static List<Borrow> listBorrowed = new ArrayList();
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
          
        
        for (int i = 0; i < ControllerBook.listAvailableBook.size(); i++){
            
            //check if the book is available to be borrowed
            if (ControllerBook.listAvailableBook.get(i).getIdBook().equals(myBook.getIdBook())
                    && ControllerBook.listAvailableBook.get(i).isIsAvailable() == true) {        
                                 
                if (myMap.get(myBook) != null){ //if the book is available, check if the map is not empty 
                    
                    //if the student who wants borrow the book is the first of the queue waiting, remove this student of the queue and let him borrow it
                    if (myStudent.getIdStudent() == myMap.get(myBook).getFirstStudentOfQueue()){
                        myMap.get(myBook).RemoveStudentQueue(myStudent.getIdStudent());
                        
                    }else{//if not, show a message with the name of the first on the queue
                        
                        for (int j=0; j < listStudent.size(); j++){//for to return the name of the first student waiting on the queue
                            
                            if (listStudent.get(j).getIdStudent()== myMap.get(myBook).getFirstStudentOfQueue()){                               
                                System.out.println("The book is not available to you yet because the first student of the queue is: " + listStudent.get(j).getfNameStudent() + " " + listStudent.get(j).getlNameStudent()+ " - id student: "
                                                    + myMap.get(myBook).getFirstStudentOfQueue()+ ".");
                                return null; //return null to don't let the student borrow 
                            }
                        }
                    }              
                }               
                ControllerBook.listAvailableBook.get(i).setIsAvailable(false); //set false when the book is borrowed

                ControllerAvailabilityBook myCAB = new ControllerAvailabilityBook();
                myCAB.gererateAvailabilityBookFile(); // call the methodo that overwrite the file AvailabilityBookFile that show the status of book.

                localTime = LocalDateTime.now();
                DateTimeFormatter dataFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                dataBorrowed = localTime.format(dataFormat);  //save the data and time the book is borrowed
       
                LocalDateTime dReturned = null;
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                Optional<LocalDateTime> optionalDate = Optional.ofNullable(dReturned);
                dataReturned = optionalDate.map(formatter::format).orElse(" --- "); //when the book is borrowed, there is no data returned

                //save the book that was borrowed and send the information and include it to the borrowing's list
                Borrow myBorred = new Borrow(myBook.getIdBook(),myBook.getBookTitle(),myStudent.getIdStudent(),
                    myStudent.getfNameStudent(),myStudent.getlNameStudent(),dataBorrowed, dataReturned);

                listBorrowed.add(myBorred);
                storageListBorrowedFile();

                Borrow myBorredByStudent = new  Borrow( myStudent.getIdStudent(),myBook);
                ListBookByStudent.add(myBorredByStudent);

                System.out.println(" \n***Confirmed the borrowing of the book to the student***\n");
                return myBorred; //return the book borrowed

            }
        }                 
                //if the book is not avaiable to be borrowed, ask the user about go to the queue
                System.out.println("Book is borrowed. Would you like to wait on the queue for the book? S/N");
                String answer = s.nextLine().toLowerCase();

                if (answer.equals("s")) {
                    waitingQueue(); //if the student wants go to the queue, call the method waitingQueue
                }
        return null;
    }

    public void waitingQueue() {
         
        if(!myMap.containsKey(myBook)){   //if in the map doesn't exist the book, insert the book in the map and a queue of students          
            myMap.put(myBook, myQueue);          
        }
        //call the method to add student on the queue
        boolean myReturn = myMap.get(myBook).AddStudentQueue(myStudent.getIdStudent()); 
       
        if (myReturn == true){ //if the method returns true, the student was add on the queue for that book

            System.out.println("\n***Confirmed! The student " + myStudent.getfNameStudent() + " "
                + myStudent.getlNameStudent() + " is on the queue for the book " + myBook.getBookTitle() + "***\n");
            storageQueueFile();
                
        }else{
            System.out.println("The student was not add on the queue, because it is full.");
        }        
    }

     public void returnBook() {
         
        myBook = myCB.searchBookByTitle(); //ask to the user which book he wants to return
        ControllerAvailabilityBook myCAB = new ControllerAvailabilityBook();

        if(myBook == null) { //book was not found
            messageError("Book");
        }else{

            for(int i = 0; i < ControllerBook.listAvailableBook.size(); i++) {

                if(ControllerBook.listAvailableBook.get(i).getIdBook().equals(myBook.getIdBook())){
                    
                    if(ControllerBook.listAvailableBook.get(i).isIsAvailable() == false){ //check if the book is borrowed

                        ControllerBook.listAvailableBook.get(i).setIsAvailable(true); //set the book to available
                        myCAB.gererateAvailabilityBookFile(); //call the method to create the file

                        localTime = LocalDateTime.now();
                        DateTimeFormatter dataFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                        dataReturned = localTime.format(dataFormat); //includes data returned

                        System.out.println("\n*Book returned!*");
                        System.out.println("Returned date: " + dataReturned + "\n");
                         
                    }else{                      
                        System.out.println("Book is not borrowed!");        
                    }
                    
                    if (myMap.get(myBook) == null){ //check if the queue for the book is empty
                        System.out.println("There is no student waiting on the queue.");
                    }else{    // if the queue is not empty, shows the first student waiting on the queue
                                           
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
         
    public void listBookBorrowByStudent() {

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
        System.out.println(listAux);        
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
    
    
    public void listStudentsQueue() {

        myBook = myCB.searchBookByTitle();
        

        if (!myMap.containsKey(myBook)) {
            System.out.println("No students are waiting for " + myBook.getBookTitle());

        } else {
            
            int[] studentQueue = myMap.get(myBook).listQueue();

            System.out.println("\n**LIST OF STUDENTS WAITING ON THE QUEUE FOR A SPECIFIC BOOK**");

            for (int i = 0; i < myMap.get(myBook).sizeOfQueue(); i++) {

                System.out.println(studentQueue[i]);

            }
        }
    }
    
    
    // storge the list borrred in  file txt.
    public  void storageQueueFile(){
        
        try {
            // try overwrite txt if something went wrong  will be have Exception
            BufferedWriter myWriter = new BufferedWriter(new FileWriter("src/library/Queue_table.csv", false));

            for (int i =0; i<myMap.get(myBook).sizeOfQueue(); i++) {

                //  write in the TXT the arralist in reverse ordem.
                myWriter.write(myMap.get(myBook) + "\n");
            }
            myWriter.close();

        }catch(Exception e) {
            System.out.println("Error writing on txt! ");
        }     
    }

    
}
