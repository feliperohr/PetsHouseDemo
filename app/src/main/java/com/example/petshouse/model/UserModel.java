package com.example.petshouse.model;

public class UserModel {
    private String name;
    private int userType;

    public UserModel(int userType) {
        this.userType = userType;
    }

    public UserModel(String name, int userType) {
        this.name = name;
        this.userType = userType;
    }

    public String getName() {
        return name;
    }

    public int getUserType() {
        return userType;
    }
}
