/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dto;

public class EmployeeDTO {
    private int id;
    private String name;
    private String phoneNumber;
    private String salary;
    private String salarydate;

    public EmployeeDTO(int id, String name, String phoneNumber,String salary, String salarydate) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.salarydate = salarydate;
    }

    public EmployeeDTO() {
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSalary(String salary) { return salary;}

    public void setSalary(String salary) {this.salary = salary;}

    public String getSalarydate() {return salarydate;}

    public void setSalarydate(String salarydate) {this.salarydate = salarydate;}
    
}
