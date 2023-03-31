/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author felipecunha
 */
public class Student {
    
    private int idStudent;
    private String firstNameStudent;
    private String lastNameStudent;   
    private String address;
    private String city;
    private String phoneNumber;
    private char gender;
    private String DOB;

    public Student(int idStudent, String firstNameStudent, String lastNameStudent, String address, String city, String phoneNumber, char gender, String DOB) {
        this.idStudent = idStudent;
        this.firstNameStudent = firstNameStudent;
        this.lastNameStudent = lastNameStudent;
        this.address = address;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.DOB = DOB;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

   

    public String getFirstNameStudent() {
        return firstNameStudent;
    }

    public void setFirstNameStudent(String firstNameStudent) {
        this.firstNameStudent = firstNameStudent;
    }

    public String getLastNameStudent() {
        return lastNameStudent;
    }

    public void setLastNameStudent(String lastNameStudent) {
        this.lastNameStudent = lastNameStudent;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    @Override
    public String toString() {
        return "Student{" + "idStudent=" + idStudent + ", firstNameStudent=" + firstNameStudent + ", lastNameStudent=" + lastNameStudent + ", address=" + address + ", city=" + city + ", phoneNumber=" + phoneNumber + ", gender=" + gender + ", DOB=" + DOB + '}'+"\n";
    }

    

  
}
