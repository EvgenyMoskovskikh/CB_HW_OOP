package com.company.hw3;

public class Manager extends Employee{
    private int countSubordinates;

    public Manager(String lastName, String name, String fathersName, String email, int phone, String department,
                   int salary, int workExperience, int countSubordinates) {
        super(lastName, name, fathersName, email, phone, department, salary, workExperience);
        this.countSubordinates = countSubordinates;
    }

    public void upSalaryHR(int ratio, HR hr){
       int salary =  hr.getSalary() + ratio;
       hr.setSalary(salary);
    }

    public void upSalaryProgrammist(int ratio, Programist programist){
        int salary =  programist.getSalary() + ratio;
        programist.setSalary(salary);
    }

    public boolean quitHR(HR hr){
        hr.setStatus(false);
        return hr.isStatus();
    }

    public boolean quitProgrammist(Programist programist){
        programist.setStatus(false);
        return programist.isStatus();
    }
    public void changeProject(Programist programist, String project){
        programist.setDepartment(project);
    }

    @Override
    public String toString() {
        return "\n\tИмя: " + this.getName() + "\n\tФамилия: " + this.getLastName() + "\n\tДепартамент: " + this.getDepartment() +
                "\n\tКоличество подчиненных: " + countSubordinates;
    }
}
