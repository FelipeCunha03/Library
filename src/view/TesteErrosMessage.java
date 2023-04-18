/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import Controller.ControllerAvailabilityBook;
import Controller.ControllerBook;
import Controller.ControllerBorrow;
import Controller.ControllerStudent;
import Controller.CustomizedQueue;
import Model.Book;
import Model.Borrow;
import Model.Student;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author felipecunha
 */
public class TesteErrosMessage {
    
    public static void main(String[] args) throws IOException {
        
       
   
       CustomizedQueue<Integer> myQueue = new CustomizedQueue(100);
       
       myQueue.AddStudentQueue(3);
       myQueue.AddStudentQueue(10);
       myQueue.AddStudentQueue(24);
       
        int[] array =  myQueue.listQueue();
        
      for(int i= 0 ; i < myQueue.sizeOfQueue(); i++ ){
     
          System.out.println("Fila : " + array[i]);
          
      }
      
       
       
     
          
       
       
       
       
    }
       
    }
    
    
    
    

