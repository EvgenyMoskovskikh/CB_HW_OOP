package com.company.hw3;

public class Programist extends Employee{
    String project;
    String programmingLanguage;

    public Programist(String lastName, String name, String fathersName, String email, int phone, String department,
                      int salary, int workExperience, String project, String programmingLanguage) {
        super(lastName, name, fathersName, email, phone, department, salary, workExperience);
        this.project = project;
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    public String toString() {
        return "\n\tИмя: " + this.getName() + "\n\tФамилия: " + this.getLastName() + "\n\tДепартамент: " + this.getDepartment() +
                "\n\tПроект: " + project + "\n\tЯП: " + programmingLanguage;
    }
}
