/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.Book;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author felipecunha
 */
public class cotrollerBook {

    /**
     * The methods that will get the file of book put in list of set.
     *
     * @return list of obj
     * @throws FileNotFoundException
     * @throws IOException
     */
    public List<Book> getBookObj() throws FileNotFoundException, IOException {

        //We had decide to use  Set TreeSet because will but in orderalphabetic and Set for avoid duplicate values , makes sense for library system.
        Set<Book> myBookSet = new HashSet<>();
        String path = "src/library/books.csv"; //path of data It is.

        BufferedReader br = new BufferedReader(new FileReader(path));
        String line = br.readLine();

        //We had put all processe for get the book from data  for treatement some exeception if will have some erroe ao open the file.  
        try {

            // Start read the file books.The Loop will try get line by line still the next line will be NULL.
            while (line != null) {

                // Created Array of String   for get  each information from file CSV.
                String[] vetBook = line.split(",");
                String idA = vetBook[0];
                String firstNameA = vetBook[1];
                String lastNameA = vetBook[2];
                String title = vetBook[3];
                String genre = vetBook[4];

                Book bookObj = new Book(idA, firstNameA, lastNameA, title, genre);

                myBookSet.add(bookObj);

                line = br.readLine(); //read the next line of file csv.

            }

        } catch (Exception e) {

            System.out.println("Error open file" + e.getMessage());
        }

        List<Book> listBook = new ArrayList<>(myBookSet);// to convert setList of book  to arrayList, I think It is easier  use List.

        return listBook;
    }

}
