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
    
    private String nameStudent;
    private int idStudent;
    private String address;
    private String phone;

    public Student(String nameStudent, int idStudent, String address, String phone) {
        this.nameStudent = nameStudent;
        this.idStudent = idStudent;
        this.address = address;
        this.phone = phone;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Student{" + "nameStudent=" + nameStudent + ", idStudent=" + idStudent + ", address=" + address + ", phone=" + phone + '}';
    }
    
    
    
}
