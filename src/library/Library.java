
/*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

import Control.cotrollerBook;
import Model.Book;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author felipecunha
 */
public class Library {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        cotrollerBook myBookController = new cotrollerBook();
        System.out.println(myBookController.getBookObj());
        
        //System.out.println(myListBook); 
  
    }
}
