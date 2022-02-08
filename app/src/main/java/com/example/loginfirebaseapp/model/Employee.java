package com.example.loginfirebaseapp.model;


public class Employee {

    private String username;
    private String designation;
    private String fullName;

    public Employee() {}
    public Employee(String username, String designation, String fullName) {
        this.username = username;
        this.designation = designation;
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
