/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Book;
import Model.Student;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author rapha
 */
public class controllerStudent {

    Scanner s = new Scanner(System.in);
    static List<Student> listStudent;

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

            System.out.println("Error to open file\nMessage error: " + e.getMessage());
        }

        listStudent = new ArrayList<>(myStudentSet);

        return listStudent;
    }
    
    

    public Student searchStudentByName() {

        String fNameStudent, lNameStudent;
        System.out.println("Inform the student's name: ");
        String studentName = s.nextLine();

        if (studentName.contains(" ")) {
            fNameStudent = studentName.substring(0, studentName.indexOf(" "));
            lNameStudent = studentName.substring(studentName.indexOf(" ") + 1);

        } else {
            System.out.println("Inform the student's full name.");
            return null;
        }

        for (int i = 0; i < listStudent.size(); i++) {

            if ((listStudent.get(i).getfNameStudent().equals(fNameStudent))
                    && (listStudent.get(i).getlNameStudent().equals(lNameStudent))) {

                return listStudent.get(i);
            }
        }
        return null;
    }

    public Student searchStudentByID() {

        boolean checkId = false;
        String idValid = null; // It was created as String because I wanted to used the regex for to valid the ID 
        //and make sure the user type just number!

        do {

            System.out.println("Informe the student's ID: ");
            idValid = s.nextLine();

            if (idValid.matches("[0-9]+")) {
                checkId = true;
            } else {
                System.out.println("Please, inform just numbers: ");
            }

        } while (checkId == false);

        int studentID = Integer.parseInt(idValid); // convert to the ID to INT because the atribute IDstudent is int 
        //and It not possible compare String vs int in the nexr for.

        for (int i = 0; i < listStudent.size(); i++) {

            if (listStudent.get(i).getIdStudent() == studentID) {
                return listStudent.get(i);

            }
        }
        return null;
    }

    public List<Student> listStudentByName() {

        for (int i = 0; i < listStudent.size(); i++) {

            for (int j = 0; j < listStudent.size() - 1; j++) {

                if (listStudent.get(j).getfNameStudent().trim().compareTo(listStudent.get(j + 1).getfNameStudent().trim()) > 0) {

                    Student tempStudent = listStudent.get(j);
                    listStudent.set(j, listStudent.get(j + 1));
                    listStudent.set(j + 1, tempStudent);
                }
            }
        }

        System.out.println("\n*************LIST STUDENTS BY NAME ORDER*************");
        return listStudent;
    }

    public List<Student> listStudentByID() {

        Student temp;
        for (int i = 0; i < listStudent.size(); i++) {

            for (int j = 0; j < listStudent.size() - 1; j++) {
                if (listStudent.get(j).getIdStudent() > listStudent.get(j + 1).getIdStudent()) {
                    temp = listStudent.get(j);
                    listStudent.set(j, listStudent.get(j + 1));
                    listStudent.set((j + 1), temp);
                }
            }
        }
        System.out.println("\n*************LIST STUDENTS BY ID ORDER*************");
        return listStudent;
    }

}
