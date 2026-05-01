package com.flowerdeskconsole.model;

public class User {
    private String userName;
    private String fullName;
    private String email;
    private String password;
    private String phoneNumber;
    private String department;
    private String role;

    public User(String userName, String fullName,
                String email, String password,String phoneNumber,
                String department, String role) {
        this.userName = userName;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.phoneNumber=phoneNumber;
        this.department = department;
        this.role = role;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getFullName() {
        return this.fullName;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public String getDepartment() {
        return this.department;
    }

    public String getRole() {
        return this.role;
    }
}
