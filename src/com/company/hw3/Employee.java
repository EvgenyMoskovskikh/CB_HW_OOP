package com.company.hw3;

import com.company.helper.ScannerHelper;

public class Employee extends User {
    private String department;
    private boolean status ;
    private int salary;
    private int workExperience;

    public Employee(String lastName, String name, String fathersName, String email, int phone, String department,
                     int salary, int workExperience) {
        super(lastName, name, fathersName, email, phone);
        this.department = department;
        this.status = true;
        this.salary = salary;
        this.workExperience = workExperience;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public void sendEmail(String email) {
        String text = ScannerHelper.getIntFromString("Введите текст сообщения: ");
        System.out.println("Сообщение \"" + text + "\" отправлено. Получатель: " + email);
    }
}
