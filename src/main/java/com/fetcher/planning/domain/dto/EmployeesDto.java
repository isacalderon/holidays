package com.fetcher.planning.domain.dto;

import java.time.LocalDateTime;

public class EmployeesDto {
     private int id;
     private String name;
     private String lastName;
     private String email;
     private LocalDateTime dateHiring;

    public LocalDateTime getDateHiring() {
        return dateHiring;
    }

    public void setDateHiring(LocalDateTime dateHiring) {
        this.dateHiring = dateHiring;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
