package com.company.hw5;

public class Employee extends User{
    String department;
    String post;

    public Employee(String surname, String name, int age, String department, String post) {
        super(surname, name, age);
        this.department = department;
        this.post = post;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return "\n\tДанные сотрудника: " +
                "\n\tФамилия: " + getSurname() +
                "\n\tИмя: " + getName() +
                "\n\tВозраст: " + getAge() +
                "\n\tДепартамент: " + getDepartment() +
                "\n\tДолжность: " + getPost() + "\n";
    }
}
