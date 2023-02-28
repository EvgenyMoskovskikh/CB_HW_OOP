package com.company.hw3;

public class HR extends Employee{

    public HR(String lastName, String name, String fathersName, String email, int phone, String department,
              int salary, int workExperience) {
        super(lastName, name, fathersName, email, phone, department, salary, workExperience);
    }

    @Override
    public String toString() {
        return "\n\tИмя: " + this.getName() + "\n\tФамилия: " + this.getLastName() + "\n\tДепартамент: " + this.getDepartment();
    }
}
