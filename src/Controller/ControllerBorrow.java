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

    List<Borrow> ListBorrowed = new ArrayList();
    static List<Borrow> ListBookByStudent = new ArrayList();
    Student myStudent;
    Book myBook;
    ControllerBook myCB = new ControllerBook();
    ControllerStudent myCS = new ControllerStudent();
    LocalDateTime localTime;
    String dataReturned, dataBorrowed;
    Map <Book, CustomizedQueue<Integer>> myMap = new HashMap<>();
    CustomizedQueue<Integer> QUEUER;
    
    

    public Borrow borrowBook() {
                
        //call the method to search book by title
        myBook = myCB.searchBookByTitle();
        if (myBook == null) {
            System.out.println("Book was not found!");
            return null;
        }
        
        
        //call the method to search student by ID
        myStudent = myCS.searchStudentByID();
        if (myStudent == null) {
            System.out.println("Student was not found!");
            return null;
        }
          
        //check if the book is available to be borrowed
        for (int i = 0; i < ControllerBook.listAvailableBook.size(); i++){
            //QUEUER = new CustomizedQueue(100);
            if (ControllerBook.listAvailableBook.get(i).getIdBook().equals(myBook.getIdBook())
                    && ControllerBook.listAvailableBook.get(i).isIsAvailable() == true) {
                
//              //check if the student is the first of the 
              //if (myStudent.getIdStudent() == myMap.get(myBook).getFirstStudentOfQueue()){
                //  myMap.get(myBook).RemoveStudentQueue(myStudent.getIdStudent());
                
                 
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

                ListBorrowed.add(myBorred);
                storageListBorrowedFile();

                Borrow myBorredByStudent = new  Borrow( myStudent.getIdStudent(),myBook);
                ListBookByStudent.add(myBorredByStudent);

                //return the book borrowed
                System.out.println(" \n***Confirmed the borrowing of the book to the student***\n");
                return myBorred;

//                }else{
//                    System.out.println("This is not the first student waiting on the queue for this book.");    
//                }
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
           QUEUER = new CustomizedQueue(100);
            
            myMap.put(myBook, QUEUER);
            //System.out.println("FOI CRIADA A LISTA DO LIVRO: \n" + myBook);
            
        }
        boolean myReturn = myMap.get(myBook).AddStudentQueue(myStudent.getIdStudent());
       
        if (myReturn = true){
//                System.out.println("TAMANHO DO MAPA DE BOOKS: " + myMap.size());              
//                System.out.println("TAMANHO DO MAPA DE STUDENTS: " + myMap.get(myBook).sizeOfQueue());
                
//                System.out.println("MEU MAPA " + myMap);
//                System.out.println("MINHA FILA " + QUEUER);
//                
                System.out.println("PRIMEIRO ESTUDANTE AGUARDANDO NA FILA: " + myMap.get(myBook).getFirstStudentOfQueue());
                System.out.println("ULTIMO ESTUDANTE AGUARDANDO NA FILA: " + myMap.get(myBook).getLastStudentOfQueue());
                
//                System.out.println("FOI INSERIDO O ESTUDANTE\n " + myStudent + "\n NA FILA DO LIVRO \n " + myBook);

                System.out.println("\n***Confirmed! The student " + myStudent.getfNameStudent() + " "
                       + myStudent.getlNameStudent() + " is on the queue for the book " + myBook.getBookTitle() + "***\n");
            }        
    }

     public void returnBook() {
         
        myBook = myCB.searchBookByTitle();
        ControllerAvailabilityBook myCAB = new ControllerAvailabilityBook();

        if(myBook == null) {
            System.out.println("Book was not found!");

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
                    
                    if (QUEUER == null){
                        System.out.println("There is no student waiting on the queue.");
                    }else{    
                                             
                        System.out.println("O PROXIMO ESTUDANTE AGUARDANDO NA FILA EH " + myMap.get(myBook).getFirstStudentOfQueue());
                        
                        
                                                
//                        for (int j=0; j < listStudent.size(); j++){
////                            
//                            if (listStudent.get(i).getIdStudent()== myMap.get(myBook).){
//                                
//                                System.out.println("The next student waiting on the queue is " + myStudent.getfNameStudent());
//                            }
//                        }
                    }        
                }   
            }
        }
    }
     
     
    public List<Borrow> listBookBorrowed() {
        System.out.println("\n*************LIST OF BOOKS BORROWED*************************");
        return ListBorrowed;
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

//   public boolean listStudentsQueue() {
//
//        myBook = myCB.searchBookByTitle();
//
//        if (!myMap.containsKey(myBook)) {
//            System.out.println("No students are waiting for " + myBook.getBookTitle());
//            return false;
//
//        }else{
//
//            System.out.println("\n*****FIRST STUDENT ON THE QUEUE FOR A SPECIFIC BOOK*****");
//
//            System.out.println(myMap.get(myBook).getFirstStudentOfQueue());
//            return true;
//                       
//        } 
//    }
    
    
    // storge the list borrred in  file txt.
    public  void storageListBorrowedFile(){
        
        try {
            // try overwrite txt if something went wrong  will be have Exception
            BufferedWriter myWriter = new BufferedWriter(new FileWriter("src/library/Borrow_table.csv", false));

            for (int i =0; i<ListBorrowed.size(); i++) {

                //  write in the TXT the arralist in reverse ordem.
                myWriter.write(ListBorrowed.get(i) + "\n");

            }
            myWriter.close();

        }catch(Exception e) {

            System.out.println("ERROR WRITE ON THE TXT! ");
        }     
    }

//    public void messageError(String caseError) {
//              
//                switch (caseError) {
//                    case "Book":
//                         System.out.println("Book was not found!");
//                     break;
//                }  
//    }
}
