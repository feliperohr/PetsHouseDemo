package com.example.petshouse.model.dto;

public class CustomerDTO {

    private  Long id;
    private  String login;
    private  String password;
    private String name;
    private String cpf;
    private String phone;
    private String animalType;


    public CustomerDTO() {
    }

    public CustomerDTO(String login, String password, String name, String cpf, String phone, String animalType) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.cpf = cpf;
        this.phone = phone;
        this.animalType = animalType;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", cpf='" + cpf + '\'' +
                ", phone='" + phone + '\'' +
                ", animalType='" + animalType + '\'' +
                '}';
    }
}
