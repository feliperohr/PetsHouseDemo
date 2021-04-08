package com.example.petshouse.model.dto;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CustomerDTO{

    private  long id;

    private  String login;

    private  String password;

    private ProfileDTO profile;

    public CustomerDTO() {
    }

    public CustomerDTO(long id) {
        this.id = id;
    }

    public CustomerDTO(String login, String password, ProfileDTO profile) {
        this.login = login;
        this.password = password;
        this.profile = profile;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ProfileDTO getProfile() {
        return profile;
    }

    public void setProfile(ProfileDTO profile) {
        this.profile = profile;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", profile=" + profile +
                '}';
    }

}
