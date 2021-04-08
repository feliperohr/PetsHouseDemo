package com.example.petshouse.model.dto;

import java.time.LocalDate;

public class TaskDTO {

    private String animalType;
    private LocalDate start_date;
    private LocalDate end_date;
    private boolean scheduled;

    private CustomerDTO customer;


    public TaskDTO() {
    }

    public TaskDTO(String animalType, LocalDate start_date, LocalDate end_date, boolean scheduled, CustomerDTO customer) {
        this.animalType = animalType;
        this.start_date = start_date;
        this.end_date = end_date;
        this.scheduled = scheduled;
        this.customer = customer;
    }

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public LocalDate getStart_date() {
        return start_date;
    }

    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }

    public LocalDate getEnd_date() {
        return end_date;
    }

    public void setEnd_date(LocalDate end_date) {
        this.end_date = end_date;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }

    public boolean isScheduled() {
        return scheduled;
    }

    public void setScheduled(boolean scheduled) {
        this.scheduled = scheduled;
    }

    @Override
    public String toString() {
        return "TaskDTO{" +
                "animalType='" + animalType + '\'' +
                ", start_date=" + start_date +
                ", end_date=" + end_date +
                ", scheduled=" + scheduled +
                ", customer=" + customer +
                '}';
    }
}
