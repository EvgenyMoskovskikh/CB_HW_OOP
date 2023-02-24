package com.company.hw5;

import java.util.ArrayList;

public class Company {
    private ArrayList<Employee> list;

    public Company() {
        this.list = new ArrayList<>();
    }

    public String showEmployee(){
        String res = "";
        int i = 1;
        for (Employee employee : list) {
//                System.out.println("\n\t№ " + i + " " + employee);
                res += "\n\t№ " + i + " " + employee;
                i++;
        }
        return res;
    }

    public void addEmployeeList(String surname, String name, int age, String department, String post){
        Employee employee = new Employee(surname, name, age, department, post);
        list.add(employee);
    }

    public void addEmployee(Employee employee){
        this.list.add(employee);
    }

    public void deleteEmployee(Employee employee){
        this.list.remove(employee);
    }

    public void changeDepartment(Employee employee, String department){
        employee.setDepartment(department);
    }

    public void changePost(Employee employee, String post){
        employee.setPost(post);
    }

    public void changeSurname(Employee employee, String surName){
        employee.setSurname(surName);
    }

    public ArrayList<Employee> getList() {
        return list;
    }

    public void setList(ArrayList<Employee> list) {
        this.list = list;
    }
}
