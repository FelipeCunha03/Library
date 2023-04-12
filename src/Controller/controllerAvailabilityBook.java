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
public class controllerAvailabilityBook {

    public void gererateAvailabilityBookFile() {

        try {
            // try overwrite txt if something went wrong  will be have Exception
            BufferedWriter myWriter = new BufferedWriter(new FileWriter("src/library/listAvailableBook_table.csv", false));

            for (int i =0; i<controllerBook.listAvailableBook.size(); i++) {

                //  write in the TXT the arralist in reverse ordem.
                myWriter.write(controllerBook.listAvailableBook.get(i) + "\n");

            }
            myWriter.close();

        } catch (Exception e) {

            System.out.println("ERROR WRITE ON THE TXT! ");

        }
       

    }

    public boolean checkBookAvailability() {

        controllerBook myCB = new controllerBook();

        //call the method to search book by title
        Book myBook = myCB.searchBookByTitle();
        String message;

        if (myBook == null) {
            //messageError("Book");
            System.out.println("Book was not found!");
        }

        for (int i = 0; i < controllerBook.listAvailableBook.size(); i++) {

            if (controllerBook.listAvailableBook.get(i).getIdBook().equals(myBook.getIdBook())) {

                if (controllerBook.listAvailableBook.get(i).isIsAvailable() == false) {
                    return  false;
                }
            } 
        }
        return true;
    }

}
