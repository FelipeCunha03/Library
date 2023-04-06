/*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

import Controller.controllerStudent;
import Controller.controllerBook;
import Model.Book;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
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

       Scanner s = new  Scanner(System.in);
       controllerBook myCB = new controllerBook();
       
        
       System.out.println("-------------------------------------------- Books --------------------------------------------------------\n");
       System.out.println(myCB.getBookObj());
            
        
       //System.out.println("-------------------------------------------- Student --------------------------------------------------------\n");
       //controllerStudent myStudentController = new controllerStudent();
       //System.out.println(myStudentController.getStudentObj());
        
    }
}
