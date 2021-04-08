package com.example.petshouse.model.dto;


public class ProfileDTO {

    private String name;

    private String cpf;

    private String phone;

    private String animalType;

    private CustomerDTO customer;

    public ProfileDTO() {
    }

    public ProfileDTO(String name, String cpf, String phone, String animalType, CustomerDTO customer) {
        this.name = name;
        this.cpf = cpf;
        this.phone = phone;
        this.animalType = animalType;
        this.customer = customer;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
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
        return "ProfileDTO{" +
                "name='" + name + '\'' +
                ", cpf='" + cpf + '\'' +
                ", phone='" + phone + '\'' +
                ", animalType='" + animalType + '\'' +
                ", customer=" + customer +
                '}';
    }
}
