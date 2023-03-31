/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.Book;
import Model.Student;
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
 * @author rapha
 */
public class controllerStudent {

    public List<Student> getStudentObj() throws FileNotFoundException, IOException {

        Set<Student> myStudentSet = new HashSet<>();
        String path = "src/library/students.csv";

        BufferedReader br = new BufferedReader(new FileReader(path));
        br.readLine(); // Read the fist line (header of file) and does not do anything.

        String line = br.readLine(); // Now read the second line and passing to String

        try {

            while (line != null) {

                String[] vetStudent = line.split(",");
                Integer idS = Integer.parseInt(vetStudent[0]);
                String firstNameS = vetStudent[1];
                String lastNameS = vetStudent[2];
                String address = vetStudent[3];
                String city = vetStudent[4];
                String phoneNumber = vetStudent[5];
                String gender = vetStudent[6];
                char charGender = gender.charAt(0);
                String DOB = vetStudent[7];

                Student studentObj = new Student(idS, firstNameS, lastNameS, address, city, phoneNumber, charGender, DOB);

                myStudentSet.add(studentObj);

                line = br.readLine();

            }

        } catch (Exception e) {

            System.out.println("Error open file" + e.getMessage());
        }

        List<Student> listStudent = new ArrayList<>(myStudentSet);

        return listStudent;
    }

}
