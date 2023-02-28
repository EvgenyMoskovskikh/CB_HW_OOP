package com.company.hw3;

public abstract class User {

    private String lastName;
    private String name;
    private String fathersName;
    private String email;
    int phone;

    public User(String lastName, String name, String fathersName, String email, int phone) {
        this.lastName = lastName;
        this.name = name;
        this.fathersName = fathersName;
        this.email = email;
        this.phone = phone;
    }

    public abstract void sendEmail(String email);

    public String getLastName() {
        return lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public int getPhone() {
        return phone;
    }
}
