/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import static Controller.ControllerBook.listBook;
import static Controller.ControllerBorrow.listBorrowed;
import Model.AvailabilityBook;
import Model.Book;
import Model.Borrow;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author felipecunha
 */
public class ControllerAvailabilityBook {

    public static List<AvailabilityBook> listAvailableBook = new ArrayList();
    
    
    public  void createdTableAvailability() throws IOException{
         try {
            // try  to creat the txt and put just with the header if something went wrong I have catch.
            BufferedWriter myWriter = new BufferedWriter(new FileWriter("src/library/Available_table.csv"));
            myWriter.write("Id Book " + "," + "Availability ");
            myWriter.close();


        } catch (Exception e) { // if something went wrong when system try to  create CSV treat Exception

            System.out.println("Erro ao create ");

        }
         
         //generateListAvailabilityBook();
    }
    
    
    public boolean  checkAvalabilityTable(){
        
        boolean check;
        File AvalabilityTable = new File("src/library/Available_table.csv");
        
        if ( AvalabilityTable.length() == 0 )
            check = true;
        else {
            check = false;
        }
     return check;
    }
    
    

    public void generateListAvailabilityBook() throws FileNotFoundException, IOException {

        Set<AvailabilityBook> AvailabilitySet = new HashSet<>();
        String path = "src/library/Available_table.csv"; //path of data It is.

        BufferedReader br = new BufferedReader(new FileReader(path));
        br.readLine();

        String line = br.readLine();

        //We had put all processe for get the book from data  for treatement some exeception if will have some erroe ao open the file.  
        try {

            String idBook;
            boolean Availability;
            // Start read the file books.The Loop will try get line by line still the next line will be NULL.
            while (line != null) {

                // Created Array of String   for get  each information from file CSV.
                String[] vetAvailability = line.split(",");
                idBook = vetAvailability[0];
                Availability = Boolean.parseBoolean(vetAvailability[1]);

                AvailabilityBook AvailabilityBookObj = new AvailabilityBook(idBook);
                AvailabilitySet.add(AvailabilityBookObj);
                line = br.readLine(); //read the next line of file csv.
            }
        } catch (Exception e) {
            System.out.println("Error open file\nMessage error: " + e.getMessage());
        }

        listAvailableBook = new ArrayList<>(AvailabilitySet);// to convert setList of book to arrayList,I think It's easier to use List for maniputation.

    }

    public void messageError(String objError) {
        System.out.println(objError + " was not found!");
    }

    public void loadAvailabilityBookFileUpdated() throws FileNotFoundException, IOException {

        String idBook;
        String AvailabilityBook;

        BufferedWriter myWriter = new BufferedWriter(new FileWriter("src/library/Available_table.csv", false));

        myWriter.write("Id Book " + "," + " Availability ");
        myWriter.newLine();

        try {

            for (int i = 0; i < listAvailableBook.size(); i++) {

                idBook = listAvailableBook.get(i).getIdBook();
                AvailabilityBook = Boolean.toString(listAvailableBook.get(i).isIsAvailable());

                myWriter.write(idBook + "," + AvailabilityBook);
                myWriter.newLine();

            }

        } catch (Exception e) {
            System.out.println("Error open file\nMessage error: " + e.getMessage());
        }
    }

    public boolean checkBookAvailability() {

        ControllerBook myCB = new ControllerBook();

        //call the method to search book by title
        Book myBook = myCB.searchBookByTitle();

        for (int i = 0; i < listAvailableBook.size(); i++) {

            if (listAvailableBook.get(i).getIdBook().equals(myBook.getIdBook())) {

                if (listAvailableBook.get(i).isIsAvailable() == false) {
                    return false;
                }
            }
        }
        return true;
    }
    
    
    
    
    
    
    /////////////// modo que funciona /////////////////////
    
    public List<AvailabilityBook> generateListAvailableBook() {

        String idbook;

        for (int i = 0; i < listBook.size(); i++) {

            idbook = listBook.get(i).getIdBook();

            AvailabilityBook myAvailable = new AvailabilityBook(idbook);
            listAvailableBook.add(myAvailable);
        }
        
        
        
        try {
            // try  to creat the txt and put just with the header if something went wrong I have catch.
            BufferedWriter myWriter = new BufferedWriter(new FileWriter("src/library/AvailableBook_table"));
            myWriter.write("Id Book " + "," + "Availability ");
            myWriter.close();


        } catch (Exception e) { // if something went wrong when system try to  create CSV treat Exception

            System.out.println("Erro ao create ");

        }
        
        
        
        //  write the listAvailableBook on file CSV.
         try{
             
             String idBookFile;
             String AvailabilityBookFile;
           
            BufferedWriter myWriter = new BufferedWriter(new FileWriter("src/library/AvailableBook_table", false));

          for (int i = 0; i < listAvailableBook.size(); i++) {

                idBookFile = listAvailableBook.get(i).getIdBook();
                AvailabilityBookFile = Boolean.toString(listAvailableBook.get(i).isIsAvailable());

                myWriter.write(idBookFile + "," + AvailabilityBookFile);
                myWriter.newLine();

            }

        }catch (Exception e){

            System.out.println("Error writing on txt! ");
        }
        
        
        return listAvailableBook;
    }

}
