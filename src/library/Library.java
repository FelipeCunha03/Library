    /*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
     */


    import Model.Book;
    import java.io.BufferedReader;
    import java.io.FileNotFoundException;
    import java.io.FileReader;
    import java.io.IOException;
    import java.util.HashSet;
    import java.util.Set;
    import java.util.TreeSet;

    /**
     *
     * @author felipecunha
     */
    public class Library {

        /**
         * @param args the command line arguments
         */
        public static void main(String[] args) throws FileNotFoundException, IOException {
            // TODO code application logic here

            //We had decide to use  Set TreeSet because will but in orderalphabetic and Set for avoid duplicate values , makes sense for library system.
            Set<Book> myBookSet = new HashSet<>();
            String path = "src/library/books.csv"; //path of data It is.



             BufferedReader br = new  BufferedReader (new FileReader(path));
             String line = br.readLine();

             //We had put all processe for get the book from data  for treatement some exeception if will have some erroe ao open the file.  
             try{

                 // Start read the file books.The Loop will try get line by line still the next line will be NULL.
                 while(line != null ){

                          // Created Array of String   for get  each information from file CSV.
                          String [] vetBook = line.split(",");
                          String id = vetBook[0];
                          String firstName =  vetBook[1];
                          String lastName =  vetBook[2];
                          String title =  vetBook[3];
                          String genero =  vetBook[4];

                          Book bookObj = new Book (id,firstName,lastName,title,genero);

                          myBookSet.add(bookObj);

                          line = br.readLine(); //  read the next line of file csv.

                      }

             }

             catch (Exception e) {

                      System.out.println("Error open file" + e.getMessage());

             }


             System.out.println(myBookSet);

        }

    }
