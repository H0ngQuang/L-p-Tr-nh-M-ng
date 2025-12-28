/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UDP;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class Employee implements Serializable{
    private static final long serialVersionUID = 20261107L;
    public String id,name,hireDate;
    public double salary;
    public Employee(String id, String name, double salary, String hireDate){
        this.id= id;
        this.name = name;
        this.salary = salary;
        this.hireDate = hireDate;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getHireDate() {
        return hireDate;
    }

    public double getSalary() {
        return salary;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
