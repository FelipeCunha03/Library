/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Book;
import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 *
 * @author felipecunha
 */
public class ControllerAvailabilityBook {

    public void gererateAvailabilityBookFile() {

        try {
            // try overwrite txt if something went wrong  will be have Exception
            BufferedWriter myWriter = new BufferedWriter(new FileWriter("src/library/listAvailableBook_table.csv", false));

            for (int i =0; i<ControllerBook.listAvailableBook.size(); i++) {

                //  write in the TXT the arralist in reverse ordem.
                myWriter.write(ControllerBook.listAvailableBook.get(i) + "\n");

            }
            myWriter.close();

        } catch (Exception e) {

            System.out.println("ERROR WRITE ON THE TXT! ");

        }
       

    }

    public boolean checkBookAvailability() {

        ControllerBook myCB = new ControllerBook();

        //call the method to search book by title
          Book myBook = myCB.searchBookByTitle();
        
        for (int i = 0; i < ControllerBook.listAvailableBook.size(); i++) {

            if (ControllerBook.listAvailableBook.get(i).getIdBook().equals(myBook.getIdBook())) {

                if (ControllerBook.listAvailableBook.get(i).isIsAvailable() == false) {
                    return  false;
                }
            } 
        }
        return true;
    }

}
